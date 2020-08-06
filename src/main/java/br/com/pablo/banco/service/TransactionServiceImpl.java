package br.com.pablo.banco.service;

import br.com.pablo.banco.controller.form.BalanceForm;
import br.com.pablo.banco.controller.form.DepositForm;
import br.com.pablo.banco.controller.form.DrawCashForm;
import br.com.pablo.banco.dto.BalanceDTO;
import br.com.pablo.banco.dto.DepositDTO;
import br.com.pablo.banco.dto.WithdrawalDTO;
import br.com.pablo.banco.model.Account;
import br.com.pablo.banco.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public BalanceDTO getBalance(BalanceForm balanceForm) {
        Optional<Account> account = accountRepository.findByAccountNumber(balanceForm.getAccountNumber());
        if (account.isPresent()) {
            String status;
            status = "Successful balance consultation";
            return  new BalanceDTO(account.get(), status);
        }
        return null;
    }

    @Override
    public DepositDTO cashDeposit(DepositForm depositForm) {
        Optional<Account> optional = accountRepository.findByAccountNumber(depositForm.getAccountNumber());
        if (optional.isPresent()) {
            String status;
            Account account = optional.get();
            account.setBalance(account.getBalance() + depositForm.getValue());

            accountRepository.save(account);
            status = "Successful deposit";
            return new DepositDTO(optional.get(), status);
        }
        return null;
    }

    @Override
    public WithdrawalDTO cashWithdrawal(DrawCashForm drawCashForm) {
        Optional<Account> optional = accountRepository.findByAccountNumber(drawCashForm.getAccountNumber());
        if (optional.isPresent()) {
            String status;
            Account account = optional.get();
            account.setBalance(account.getBalance() - drawCashForm.getValue());

            accountRepository.save(account);
            status = "Successful withdrawal";
            return new WithdrawalDTO(optional.get(), status);
        }
        return null;
    }
}
