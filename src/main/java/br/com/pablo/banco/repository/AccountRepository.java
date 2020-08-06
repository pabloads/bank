package br.com.pablo.banco.repository;

import br.com.pablo.banco.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
     Optional<Account> findByAccountNumber(Integer accountNumber);
}
