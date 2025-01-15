package com.tekarch.Fund_TransferMs2.services;

import com.tekarch.Fund_TransferMs2.models.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {

    Transaction transferFunds(Transaction fundTransfer);
    List<Transaction> getAllTransactions();
    Optional<Transaction> getTransactionById(Long transferId);
}
