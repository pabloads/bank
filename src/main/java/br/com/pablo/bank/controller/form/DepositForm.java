package br.com.pablo.bank.controller.form;

import br.com.pablo.bank.model.Account;
import br.com.pablo.bank.model.AccountType;
import br.com.pablo.bank.repository.AccountRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class DepositForm {
    @NotNull
    private Integer accountNumber;
    @NotNull
    private Integer agencyNumber;
    @NotNull
    private AccountType accountType;
    private String transactionType;
    @NotNull
    private Long value;
    public Optional<Account> converter(AccountRepository accountRepository) {
        return accountRepository.findByAccountNumberAndAgencyNumberAndAccountType(agencyNumber, agencyNumber, accountType);
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
