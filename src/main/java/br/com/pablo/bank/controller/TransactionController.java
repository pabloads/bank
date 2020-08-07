package br.com.pablo.bank.controller;

import br.com.pablo.bank.controller.form.BalanceForm;
import br.com.pablo.bank.controller.form.DepositForm;
import br.com.pablo.bank.controller.form.DrawCashForm;
import br.com.pablo.bank.dto.BalanceDTO;
import br.com.pablo.bank.dto.DepositDTO;
import br.com.pablo.bank.dto.WithdrawalDTO;
import br.com.pablo.bank.model.AccountType;
import br.com.pablo.bank.service.TransactionServiceImpl;
import org.hibernate.dialect.Ingres10Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionService;

/*    @GetMapping("/balance")
    public ResponseEntity<BalanceDTO> getBalance(@RequestBody @Valid BalanceForm form) {
        BalanceDTO balanceDTO = transactionService.getBalance(form);
        if (balanceDTO != null) {
            return  ResponseEntity.ok(balanceDTO);
        }
        return ResponseEntity.notFound().build();
    }*/

    @CrossOrigin(origins  = "http://localhost:4200")
    @GetMapping("/balance")
    public ResponseEntity<BalanceDTO> getBalance(@RequestParam Integer accountNumber,
                                                 @RequestParam Integer agencyNumber,
                                                 @RequestParam String accountType) {
        AccountType at = AccountType.valueOf(accountType);
        BalanceForm balanceForm = new BalanceForm(accountNumber, agencyNumber, at);
        BalanceDTO balanceDTO = transactionService.getBalance(balanceForm);
        if (balanceDTO != null) {
            return  ResponseEntity.ok(balanceDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/balance")
    public ResponseEntity<DepositDTO> cashDeposit(@RequestBody @Valid DepositForm form, UriComponentsBuilder uriBuilder) {
        DepositDTO depositDTO = transactionService.cashDeposit(form);
        if (depositDTO != null) {
            return  ResponseEntity.ok(depositDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/balance")
    public ResponseEntity<WithdrawalDTO> cashWithdrawal(@RequestBody @Valid DrawCashForm form, UriComponentsBuilder uriBuilder) {
        WithdrawalDTO drawCashDTO = transactionService.cashWithdrawal(form);
        if (drawCashDTO != null) {
            return  ResponseEntity.ok(drawCashDTO);
        }
        return ResponseEntity.notFound().build();
    }

}
