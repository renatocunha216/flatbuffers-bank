package br.com.rbcti.flatbuffers;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.flatbuffers.FlatBufferBuilder;

import br.com.rbcti.flatbuffers.tb.AuthenticationCodeFbs;
import br.com.rbcti.flatbuffers.tb.BankAccountFbs;
import br.com.rbcti.flatbuffers.tb.BankFbs;
import br.com.rbcti.flatbuffers.tb.BankTransactionFbs;
import br.com.rbcti.flatbuffers.tb.DateTimeFbs;
import br.com.rbcti.flatbuffers.tb.FundTransferFbs;
import br.com.rbcti.model.Bank;

/**
 * Example of using FlatBuffer creating bank transactions.<br>
 *
 * Create value transfer transactions with random values and store
 * the data in a binary file.
 *
 * @author Renato Cunha
 * @version 1.0 28/07/2023
 *
 */
public class BankTransactionWriter {

    public static boolean DEBUG = true;

    private FlatBufferBuilder builder;

    // Control fields for transaction generation
    private int TOTAL_TRANSACTION;
    private LocalDateTime baseLocalDateTime = LocalDateTime.of(2023, 1, 1, 0, 0, 0);

    private float[] randomFeeAmount;
    private double[] randomAmountTransfert;
    private byte[][] randomAuthenticationCode;

    private int bankIndex = 0;
    private int checkDigit = 0;

    private List<Bank> banks;
    private int[] banksOffsets;

    public BankTransactionWriter() {
        this(5);
    }

    public BankTransactionWriter(int totalTransaction) {

        TOTAL_TRANSACTION = totalTransaction;

        this.banks = new ArrayList<>();
        banks.add(new Bank(9313, "ABN AMRO S.A."));
        banks.add(new Bank(1, "Banco do Brasil"));
        banks.add(new Bank(4041, "Banrisul"));
        banks.add(new Bank(5237, "Bradesco"));
        banks.add(new Bank(745, "Citibank"));
        banks.add(new Bank(4048, "Itaú"));
        banks.add(new Bank(7376, "J.P. Morgan S.A."));
        banks.add(new Bank(260, "Nubank"));
        banks.add(new Bank(3008, "Santander"));

        banksOffsets = new int[banks.size()];

        randomFeeAmount = new float[TOTAL_TRANSACTION];
        randomAmountTransfert = new double[TOTAL_TRANSACTION];
        randomAuthenticationCode = new byte[TOTAL_TRANSACTION][16];

        fillRandomFeeAmount();
        fillRandomAmountTransfer();
        fillRandomAuthenticationCode();

        bankIndex = 0;

        builder = new FlatBufferBuilder();
    }

    public void buildBankBuffer() {
        int i = 0;
        for (Bank bank : banks) {
            banksOffsets[i++] = BankFbs.createBankFbs(builder, builder.createString(bank.getName()), bank.getCode().intValue());
        }
    }

    public int createBankTransaction() {

        int[] fundTransferOffsets = new int[TOTAL_TRANSACTION];

        for (int c = 0; c < TOTAL_TRANSACTION; c++) {

            LocalDateTime dateTime = getNextLocalDateTime(c);
            int day = dateTime.getDayOfMonth();
            int month = dateTime.getMonthValue();
            int year = dateTime.getYear();
            int hour = dateTime.getHour();
            int minute = dateTime.getMinute();
            int seconds = dateTime.getSecond();

            int sourceBankAccountOffset = BankAccountFbs.createBankAccountFbs(builder, c, getNextCheckDigit());
            int destinationBankAccountOffset = BankAccountFbs.createBankAccountFbs(builder, c + 1, getNextCheckDigit());

            FundTransferFbs.startFundTransferFbs(builder);
            FundTransferFbs.addTransferDate(builder, DateTimeFbs.createDateTimeFbs(builder, day, month, year, hour, minute, seconds));
            FundTransferFbs.addSourceBank(builder, banksOffsets[getNextBankIndex()]);
            FundTransferFbs.addSourceBankAccount(builder, sourceBankAccountOffset);
            FundTransferFbs.addDestinationBank(builder, banksOffsets[getNextBankIndex()]);
            FundTransferFbs.addDestinationBankAccount(builder, destinationBankAccountOffset);
            FundTransferFbs.addFeeAmount(builder, randomFeeAmount[c]);
            FundTransferFbs.addAmountTransfer(builder, randomAmountTransfert[c]);
            FundTransferFbs.addAuthenticationCode(builder, AuthenticationCodeFbs.createAuthenticationCodeFbs(builder, randomAuthenticationCode[c]));
            fundTransferOffsets[c] = FundTransferFbs.endFundTransferFbs(builder);
        }

        int dataOffset = BankTransactionFbs.createTransactionsVector(builder, fundTransferOffsets);

        return dataOffset;
    }

    public FlatBufferBuilder getBuilder() {
        return builder;
    }

    private void addTransactionsAndFinish(int dataOffset) {
        BankTransactionFbs.startBankTransactionFbs(builder);
        BankTransactionFbs.addTransactions(builder, dataOffset);
        int endOffset = BankTransactionFbs.endBankTransactionFbs(builder);
        BankTransactionFbs.finishBankTransactionFbsBuffer(builder, endOffset);
    }


    private void fillRandomFeeAmount() {
        for (int c = 0; c < TOTAL_TRANSACTION; c++) {
            randomFeeAmount[c] = (float) randomDouble(100);
        }
    }

    private void fillRandomAmountTransfer() {
        for (int c = 0; c < TOTAL_TRANSACTION; c++) {
            randomAmountTransfert[c] = randomDouble(1000000);
        }
    }

    private void fillRandomAuthenticationCode() {
        SecureRandom random = new SecureRandom();
        for (int c = 0; c < TOTAL_TRANSACTION; c++) {
            random.nextBytes(randomAuthenticationCode[c]);
        }
    }

    private static double round(double value, int places) {
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }


    private static double randomDouble(int limit) {
        Random rand = new Random();
        double value = rand.nextDouble() * limit;
        return round(value, 2);
    }

    private LocalDateTime getNextLocalDateTime(int sum) {
        return baseLocalDateTime.plusDays(sum).plusMinutes(sum).plusSeconds(sum);
    }

    private void resetControlIndex() {
        bankIndex = 0;
        checkDigit = 0;
    }

    private int getNextBankIndex() {
        if (bankIndex >= banks.size()) {
            bankIndex = 0;
        }
        return bankIndex++;
    }

    private int getNextCheckDigit() {
        if (checkDigit > 9) {
            checkDigit = 0;
        }
        return checkDigit++;
    }

    public void clearBuffer() {
        builder.clear();
    }

    public void saveToFile() {
        byte[] transactionsData = this.builder.sizedByteArray();

        Path path = Path.of(System.getProperty("user.home"), "bankTransaction.bin");

        try {
            Files.write(path, transactionsData);

            System.out.println(path.toString() + " file was successfully created.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readAndCheck() {

        resetControlIndex();

        Path path = Path.of(System.getProperty("user.home"), "bankTransaction.bin");

        File transactionsFile = path.toFile();

        if (!transactionsFile.exists()) {
            System.err.println("File not found.");
            return;
        }

        try {
            byte[] transactionsData = Files.readAllBytes(path);

            BankTransactionFbs bankTransaction = BankTransactionFbs.getRootAsBankTransactionFbs(ByteBuffer.wrap(transactionsData));

            int transactionsLength = bankTransaction.transactionsLength();

            if (transactionsLength < 1) {
                System.err.println("No data found.");
                return;
            }

            for (int c = 0; c < transactionsLength; c++) {
                FundTransferFbs fundTransfer = bankTransaction.transactions(c);

                DateTimeFbs transferDate = fundTransfer.transferDate();
                BankFbs sourceBank = fundTransfer.sourceBank();
                BankAccountFbs sourceBankAccount = fundTransfer.sourceBankAccount();
                BankFbs destinationBank = fundTransfer.destinationBank();
                BankAccountFbs destinationBankAccount = fundTransfer.destinationBankAccount();
                float feeAmount = fundTransfer.feeAmount();
                double amountTransfer = fundTransfer.amountTransfer();
                AuthenticationCodeFbs authenticationCode = fundTransfer.authenticationCode();

                LocalDateTime dateTimeRef = getNextLocalDateTime(c);

                if ((transferDate.day() != dateTimeRef.getDayOfMonth()) ||
                        (transferDate.month() != dateTimeRef.getMonthValue()) ||
                        (transferDate.year() != dateTimeRef.getYear()) ||
                        (transferDate.hour() != dateTimeRef.getHour()) ||
                        (transferDate.minute() != dateTimeRef.getMinute()) ||
                        (transferDate.second() != dateTimeRef.getSecond())) {
                    throw new Exception("Transaction " + c + ". Transfer date validation error.");
                }

                Bank sourceBankRef = this.banks.get(getNextBankIndex());
                Bank destinationBankRef = this.banks.get(getNextBankIndex());

                if (!sourceBank.name().equals(sourceBankRef.getName()) || sourceBank.bankCode() != sourceBankRef.getCode().intValue()) {
                    throw new Exception("Transaction " + c + ". Source Bank validation error.");
                }

                if ((sourceBankAccount.accountNumber() != c) || (sourceBankAccount.checkDigit() != getNextCheckDigit())) {
                    throw new Exception("Transaction " + c + ". Source Bank Account validation error.");
                }

                if (!destinationBank.name().equals(destinationBankRef.getName()) || destinationBank.bankCode() != destinationBankRef.getCode().intValue()) {
                    throw new Exception("Transaction " + c + ". Destination Bank validation error.");
                }

                if ((destinationBankAccount.accountNumber() != (c + 1)) || (destinationBankAccount.checkDigit() != getNextCheckDigit())) {
                    throw new Exception("Transaction " + c + ". Source Bank Account validation error.");
                }

                if (feeAmount != this.randomFeeAmount[c]) {
                    throw new Exception("Transaction " + c + ". Fee amount validation error.");
                }

                if (amountTransfer != this.randomAmountTransfert[c]) {
                    throw new Exception("Transaction " + c + ". Amount transfer validation error.");
                }

                for (int x = 0; x < 16; x++) {
                    if (authenticationCode.value(x) != randomAuthenticationCode[c][x]) {
                        throw new Exception("Transaction " + c + ". Authentication code validation error.");
                    }
                }

                if (DEBUG) {
                    System.out.println("Transaction " + c + ". Check OK!");
                }

            }


        } catch (IOException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        DEBUG = false;

        final int TOTAL = 10_000;

        System.out.println("Start test.");

        BankTransactionWriter writer = new BankTransactionWriter(TOTAL);


        long startTime1 = System.currentTimeMillis();
        writer.buildBankBuffer();
        int dataOffset = writer.createBankTransaction();
        writer.addTransactionsAndFinish(dataOffset);
        long endTime1 = System.currentTimeMillis();

        writer.saveToFile();
        writer.clearBuffer();

        long startTime2 = System.currentTimeMillis();
        writer.readAndCheck();
        long endTime2 = System.currentTimeMillis();

        System.out.println("Buffer build time: " + (endTime1 - startTime1) + " ms");
        System.out.println("Reading and checking time: " + (endTime2 - startTime2) + " ms");

        System.out.println("End test.");
    }

}
