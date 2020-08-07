package br.com.pablo.bank.repository;

import br.com.pablo.bank.model.Account;
import br.com.pablo.bank.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
     Optional<Account> findByAccountNumber(Integer accountNumber);
     Optional<Account> findByAccountNumberAndAgencyNumberAndAccountType(Integer accountNumber,
                                                                        Integer agencyNumber, AccountType accountType);
}
