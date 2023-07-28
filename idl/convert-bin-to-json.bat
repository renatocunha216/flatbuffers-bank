@echo off
call flatc --json Common.fbs BankTransactions.fbs ^
--strict-json ^
--defaults-json ^
--natural-utf8 ^
-- bankTransaction.bin

if not %errorlevel%==0 goto end1

echo --------------------------------
echo JSON file successfully created
echo --------------------------------

:end1
