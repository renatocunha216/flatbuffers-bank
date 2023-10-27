@echo off
call flatc --java Common.fbs BankTransactions.fbs

if not %errorlevel% == 0 goto end

call flatc --cpp Common.fbs BankTransactions.fbs

if not %errorlevel% == 0 goto end

echo --------------------------------
echo Successfully created artifacts
echo --------------------------------

:end
