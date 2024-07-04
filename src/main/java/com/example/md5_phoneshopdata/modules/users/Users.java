package com.example.md5_phoneshopdata.modules.users;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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
    @Column(unique = true)
    private String userName;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(unique = true)
    private String phone;
    private String address = null;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String date ;
    @DateTimeFormat(pattern = "dd/MM/yyyy")

    private String updateDate = new Date().toString();
    private boolean status = false;
    private boolean userRole = false;



    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", date='" + date + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", status=" + status +
                '}';
    }


}
