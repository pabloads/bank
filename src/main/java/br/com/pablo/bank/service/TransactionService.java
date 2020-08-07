package br.com.pablo.bank.service;

import br.com.pablo.bank.controller.form.BalanceForm;
import br.com.pablo.bank.controller.form.DepositForm;
import br.com.pablo.bank.controller.form.DrawCashForm;
import br.com.pablo.bank.dto.BalanceDTO;
import br.com.pablo.bank.dto.DepositDTO;
import br.com.pablo.bank.dto.WithdrawalDTO;

public interface TransactionService {
    BalanceDTO getBalance(BalanceForm balanceForm);
    DepositDTO cashDeposit(DepositForm depositForm);
    WithdrawalDTO cashWithdrawal(DrawCashForm drawCashForm);
}
