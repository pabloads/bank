package br.com.pablo.banco.dto;

import br.com.pablo.banco.model.Account;
import br.com.pablo.banco.model.AccountType;

public class WithdrawalDTO {
    private Integer agencyNumber;
    private Integer accountNumber;
    private AccountType accountType;
    private Long balance;
    private String status;

    public WithdrawalDTO(Account account, String status) {
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
