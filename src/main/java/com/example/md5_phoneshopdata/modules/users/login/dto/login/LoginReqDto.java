package com.example.md5_phoneshopdata.modules.users.login.dto.login;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginReqDto {
    String loginId;
    String password;
    boolean status;
}
