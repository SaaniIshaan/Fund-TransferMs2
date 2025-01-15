package com.tekarch.Fund_TransferMs2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

 //   private Long userId;
    private String username;
    private String email;
    private String password_hash;
    private String phone_number;
    private Boolean two_factor_enabled = false;
 //   private LocalDateTime created_at;
 //   private LocalDateTime updated_at;
    private String kyc_status = "pending";
}
