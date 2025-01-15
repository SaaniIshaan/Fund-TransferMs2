package com.tekarch.Fund_TransferMs2.controller;

import com.tekarch.Fund_TransferMs2.models.Transaction;
import com.tekarch.Fund_TransferMs2.services.TransactionServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private static final Logger logger = LogManager.getLogger(TransactionServiceImpl.class);

    @Autowired
    private TransactionServiceImpl transactionServiceImpl;

    @PostMapping
    public ResponseEntity<Transaction> initiateTransfer(@RequestBody Transaction fundTransfer) {
        Transaction initiatedTransfer = transactionServiceImpl.transferFunds(fundTransfer);
        return new ResponseEntity<>(initiatedTransfer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransfers() {
        return new ResponseEntity<>(transactionServiceImpl.getAllTransactions(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransferById(@PathVariable Long id) {
        Optional<Transaction> transaction = transactionServiceImpl.getTransactionById(id);

        //Using ternary operator
      //  ex. return 1==2 ? "a" : "b"
//        return transactions.isEmpty()
//                ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
//                : new ResponseEntity<>(transactions.get(), HttpStatus.OK);

        return transaction.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
