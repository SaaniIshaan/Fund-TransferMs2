package com.tekarch.Fund_TransferMs2.services;

import com.tekarch.Fund_TransferMs2.models.AccountDTO;
import com.tekarch.Fund_TransferMs2.models.Transaction;
import com.tekarch.Fund_TransferMs2.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${accounts.ms.url}")
    String url;

//    String ACCOUNT_SERVICE_URL = "http://localhost:8081/accounts";
//    String USER_SERVICE_URL = "http://localhost:8080/users";

    @Override
    public Transaction transferFunds(Transaction fundTransfer) {
        AccountDTO receiverAccount = restTemplate.getForObject( url + "/" + fundTransfer.getReceiver_account_id(),
                AccountDTO.class);
        AccountDTO senderAccount = restTemplate.getForObject(url + "/" + fundTransfer.getSender_account_id(),
              AccountDTO.class);

        if(receiverAccount.getAccountNumber() == null || senderAccount.getAccountNumber() == null) {
            throw new RuntimeException("Invalid Account");
        }

        receiverAccount.setBalance(receiverAccount.getBalance() + fundTransfer.getAmount());
        senderAccount.setBalance(senderAccount.getBalance() - fundTransfer.getAmount());

        restTemplate.put(url, senderAccount);
        restTemplate.put(url, receiverAccount);

        return transactionRepository.save(fundTransfer);

    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> getTransactionById(Long transferId) {
        return transactionRepository.findById(transferId);
    }
}
