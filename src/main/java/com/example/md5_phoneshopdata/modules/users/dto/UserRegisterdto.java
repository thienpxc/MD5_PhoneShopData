package com.example.md5_phoneshopdata.modules.users.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRegisterdto {
    @Size(min = 3, max = 50, message = "Tên người dùng phải từ 3 đến 50 ký tự")
    @Column(unique = true)
    private String userName;
    @Pattern(regexp = "^\\d{10}$", message = "Số điện thoại phải có 10 chữ số")
    @Column(unique = true)
    private String phone;
    @Column(unique = true)

    @Email(message = "Email không hợp lệ")
    private String email;
    private Date date;
    private String password;


}
