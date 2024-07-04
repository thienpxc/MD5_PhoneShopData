package com.example.md5_phoneshopdata.modules.users.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor

@Getter
@Setter
public class Error {
    private String message;

    public Error(String message) {
        this.message = message;
    }
}
