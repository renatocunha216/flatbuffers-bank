// automatically generated by the FlatBuffers compiler, do not modify

package br.com.rbcti.flatbuffers.tb;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.BooleanVector;
import com.google.flatbuffers.ByteVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.DoubleVector;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.FloatVector;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.LongVector;
import com.google.flatbuffers.ShortVector;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Struct;
import com.google.flatbuffers.Table;
import com.google.flatbuffers.UnionVector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class FundTransferFbs extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_23_5_26(); }
  public static FundTransferFbs getRootAsFundTransferFbs(ByteBuffer _bb) { return getRootAsFundTransferFbs(_bb, new FundTransferFbs()); }
  public static FundTransferFbs getRootAsFundTransferFbs(ByteBuffer _bb, FundTransferFbs obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public FundTransferFbs __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public br.com.rbcti.flatbuffers.tb.DateTimeFbs transferDate() { return transferDate(new br.com.rbcti.flatbuffers.tb.DateTimeFbs()); }
  public br.com.rbcti.flatbuffers.tb.DateTimeFbs transferDate(br.com.rbcti.flatbuffers.tb.DateTimeFbs obj) { int o = __offset(4); return o != 0 ? obj.__assign(o + bb_pos, bb) : null; }
  public br.com.rbcti.flatbuffers.tb.BankFbs sourceBank() { return sourceBank(new br.com.rbcti.flatbuffers.tb.BankFbs()); }
  public br.com.rbcti.flatbuffers.tb.BankFbs sourceBank(br.com.rbcti.flatbuffers.tb.BankFbs obj) { int o = __offset(6); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }
  public br.com.rbcti.flatbuffers.tb.BankAccountFbs sourceBankAccount() { return sourceBankAccount(new br.com.rbcti.flatbuffers.tb.BankAccountFbs()); }
  public br.com.rbcti.flatbuffers.tb.BankAccountFbs sourceBankAccount(br.com.rbcti.flatbuffers.tb.BankAccountFbs obj) { int o = __offset(8); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }
  public br.com.rbcti.flatbuffers.tb.BankFbs destinationBank() { return destinationBank(new br.com.rbcti.flatbuffers.tb.BankFbs()); }
  public br.com.rbcti.flatbuffers.tb.BankFbs destinationBank(br.com.rbcti.flatbuffers.tb.BankFbs obj) { int o = __offset(10); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }
  public br.com.rbcti.flatbuffers.tb.BankAccountFbs destinationBankAccount() { return destinationBankAccount(new br.com.rbcti.flatbuffers.tb.BankAccountFbs()); }
  public br.com.rbcti.flatbuffers.tb.BankAccountFbs destinationBankAccount(br.com.rbcti.flatbuffers.tb.BankAccountFbs obj) { int o = __offset(12); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }
  public float feeAmount() { int o = __offset(14); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  public double amountTransfer() { int o = __offset(16); return o != 0 ? bb.getDouble(o + bb_pos) : 0.0; }
  public byte status() { int o = __offset(18); return o != 0 ? bb.get(o + bb_pos) : 0; }
  public br.com.rbcti.flatbuffers.tb.AuthenticationCodeFbs authenticationCode() { return authenticationCode(new br.com.rbcti.flatbuffers.tb.AuthenticationCodeFbs()); }
  public br.com.rbcti.flatbuffers.tb.AuthenticationCodeFbs authenticationCode(br.com.rbcti.flatbuffers.tb.AuthenticationCodeFbs obj) { int o = __offset(20); return o != 0 ? obj.__assign(o + bb_pos, bb) : null; }

  public static void startFundTransferFbs(FlatBufferBuilder builder) { builder.startTable(9); }
  public static void addTransferDate(FlatBufferBuilder builder, int transferDateOffset) { builder.addStruct(0, transferDateOffset, 0); }
  public static void addSourceBank(FlatBufferBuilder builder, int sourceBankOffset) { builder.addOffset(1, sourceBankOffset, 0); }
  public static void addSourceBankAccount(FlatBufferBuilder builder, int sourceBankAccountOffset) { builder.addOffset(2, sourceBankAccountOffset, 0); }
  public static void addDestinationBank(FlatBufferBuilder builder, int destinationBankOffset) { builder.addOffset(3, destinationBankOffset, 0); }
  public static void addDestinationBankAccount(FlatBufferBuilder builder, int destinationBankAccountOffset) { builder.addOffset(4, destinationBankAccountOffset, 0); }
  public static void addFeeAmount(FlatBufferBuilder builder, float feeAmount) { builder.addFloat(5, feeAmount, 0.0f); }
  public static void addAmountTransfer(FlatBufferBuilder builder, double amountTransfer) { builder.addDouble(6, amountTransfer, 0.0); }
  public static void addStatus(FlatBufferBuilder builder, byte status) { builder.addByte(7, status, 0); }
  public static void addAuthenticationCode(FlatBufferBuilder builder, int authenticationCodeOffset) { builder.addStruct(8, authenticationCodeOffset, 0); }
  public static int endFundTransferFbs(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public FundTransferFbs get(int j) { return get(new FundTransferFbs(), j); }
    public FundTransferFbs get(FundTransferFbs obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
}

