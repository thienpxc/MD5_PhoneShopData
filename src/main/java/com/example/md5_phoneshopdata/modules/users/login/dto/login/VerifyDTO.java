package com.example.md5_phoneshopdata.modules.users.login.dto.login;

import com.example.md5_phoneshopdata.modules.users.Users;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class VerifyDTO {
    String message;
    Users data;
}
