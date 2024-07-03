package com.example.md5_phoneshopdata.modules.users.dto.login;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginReqDto {
    String loginId;
    String password;
}
