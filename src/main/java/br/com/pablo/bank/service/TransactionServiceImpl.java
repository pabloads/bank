package br.com.pablo.bank.service;

import br.com.pablo.bank.controller.form.BalanceForm;
import br.com.pablo.bank.controller.form.DepositForm;
import br.com.pablo.bank.controller.form.DrawCashForm;
import br.com.pablo.bank.dto.BalanceDTO;
import br.com.pablo.bank.dto.DepositDTO;
import br.com.pablo.bank.dto.WithdrawalDTO;
import br.com.pablo.bank.model.Account;
import br.com.pablo.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public BalanceDTO getBalance(BalanceForm balanceForm) {
        Optional<Account> account = accountRepository.findByAccountNumberAndAgencyNumberAndAccountType(balanceForm.getAccountNumber(),
                balanceForm.getAgencyNumber(), balanceForm.getAccountType());
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
            if (canWithdrawal(account.getBalance(), drawCashForm.getValue())) {

                account.setBalance(account.getBalance() - drawCashForm.getValue());

                accountRepository.save(account);
                status = "Successful withdrawal";
                return new WithdrawalDTO(optional.get(), status);
            }
        }
        return null;
    }

    public Boolean canWithdrawal(Long actualBalance, Long withdrawalBalance) {
        if (actualBalance < withdrawalBalance) {
            return false;
        }
        return true;
    }
}
