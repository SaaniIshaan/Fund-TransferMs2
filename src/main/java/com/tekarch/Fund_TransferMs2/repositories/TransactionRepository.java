package com.tekarch.Fund_TransferMs2.repositories;


import com.tekarch.Fund_TransferMs2.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
