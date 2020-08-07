package br.com.pablo.bank.dto;

import br.com.pablo.bank.model.Account;
import br.com.pablo.bank.model.AccountType;

public class BalanceDTO {
    private Integer agencyNumber;
    private Integer accountNumber;
    private AccountType accountType;
    private Long balance;
    private String status;

    public BalanceDTO(Account account, String status) {
        this.balance = account.getBalance();
        this.balance = account.getBalance();
        this.agencyNumber = account.getAgencyNumber();
        this.accountNumber = account.getAccountNumber();
        this.accountType = account.getAccountType();
        this.status = status;
    }

    public Long getBalance() {
        return balance;
    }

    public Integer getAgencyNumber() {
        return agencyNumber;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getStatus() {
        return status;
    }
}
