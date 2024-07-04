package com.example.md5_phoneshopdata.modules.users.login.dto;

import com.example.md5_phoneshopdata.modules.users.Users;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateRespone {
    private String message;
    private Users data;

    @Override
    public String toString() {
        return "CreateRespone{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
