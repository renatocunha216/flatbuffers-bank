@echo off
call flatc -t Common.fbs BankTransactions.fbs -- bankTransaction.bin

if not %errorlevel%==0 goto end1

echo --------------------------------
echo JSON file successfully created
echo --------------------------------

:end1
