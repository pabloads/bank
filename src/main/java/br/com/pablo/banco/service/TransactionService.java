package br.com.pablo.banco.service;

import br.com.pablo.banco.controller.form.BalanceForm;
import br.com.pablo.banco.controller.form.DepositForm;
import br.com.pablo.banco.controller.form.DrawCashForm;
import br.com.pablo.banco.dto.BalanceDTO;
import br.com.pablo.banco.dto.DepositDTO;
import br.com.pablo.banco.dto.WithdrawalDTO;

public interface TransactionService {
    BalanceDTO getBalance(BalanceForm balanceForm);
    DepositDTO cashDeposit(DepositForm depositForm);
    WithdrawalDTO cashWithdrawal(DrawCashForm drawCashForm);
}
