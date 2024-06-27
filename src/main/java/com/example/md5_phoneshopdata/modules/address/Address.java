package com.example.md5_phoneshopdata.modules.address;

import jakarta.persistence.*;
import lombok.*;
import com.example.md5_phoneshopdata.modules.users.Users;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    private String addressDetail;
    private String phone;
    private String receiverName;
}
