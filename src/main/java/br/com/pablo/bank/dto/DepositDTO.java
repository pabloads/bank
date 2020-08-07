package br.com.pablo.bank.dto;

import br.com.pablo.bank.model.Account;
import br.com.pablo.bank.model.AccountType;

public class DepositDTO {
    private Long balance;
    private Integer accountNumber;
    private Integer agencyNumber;
    private AccountType accountType;
    private String transactionType;
    private String status;

    public DepositDTO(Account account, String status) {
        this.balance = account.getBalance();
        this.agencyNumber = account.getAgencyNumber();
        this.accountNumber = account.getAccountNumber();
        this.accountType = account.getAccountType();
        this.status = status;
    }

    public Long getBalance() {
        return balance;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public Integer getAgencyNumber() {
        return agencyNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getStatus() {
        return status;
    }

}
