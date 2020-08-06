package br.com.pablo.banco.model;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer accountNumber;
    private Integer agencyNumber;
    private Long balance;
    @Enumerated(EnumType.STRING) // Guardar o nome da constante no banco. Por padrão, grava a ordem.
    private AccountType accountType;
    @ManyToOne
    private Customer customer;

    public Account() {
    }

    public Account(Integer accountNumber, Integer agencyNumber, Long balance, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
