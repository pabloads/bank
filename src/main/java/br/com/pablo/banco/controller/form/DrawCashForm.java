package br.com.pablo.banco.controller.form;

import br.com.pablo.banco.model.Account;
import br.com.pablo.banco.model.AccountType;
import br.com.pablo.banco.repository.AccountRepository;

import java.util.Optional;

public class DrawCashForm {
    private Integer accountNumber;
    private Integer agencyNumber;
    private AccountType accountType;
    private String transactionType;
    private Long value;

    public Optional<Account> converter(AccountRepository accountRepository) {
        return accountRepository.findByAccountNumber(agencyNumber);
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getAgencyNumber() {
        return agencyNumber;
    }

    public void setAgencyNumber(Integer agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
