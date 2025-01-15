package com.tekarch.Fund_TransferMs2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountDTO {

    private Long accountId;
    private String accountNumber;
    private String accountType;
    private Double balance;
}
