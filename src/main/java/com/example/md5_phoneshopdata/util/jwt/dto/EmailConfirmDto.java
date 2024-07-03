package com.example.md5_phoneshopdata.util.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmailConfirmDto {
    public String email;
    public Integer id;
}
