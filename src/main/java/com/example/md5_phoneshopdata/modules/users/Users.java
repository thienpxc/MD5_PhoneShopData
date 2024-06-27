package com.example.md5_phoneshopdata.modules.users;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String email;
    private String fullName;
    private boolean status;
    private String password;
    private String phone;
    private String address;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String date;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String updateDate;
    private boolean isDeleted;


}
