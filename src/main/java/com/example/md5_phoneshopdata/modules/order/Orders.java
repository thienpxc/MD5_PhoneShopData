package com.example.md5_phoneshopdata.modules.order;

import com.example.md5_phoneshopdata.modules.users.Users;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


public class Orders {
    enum Status {
        WAITING,
        CONFIRMED,
        DELIVERED,
        SUCCESS,
        CANCEL,
        DELETED
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String serialNumber;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    private double totalPrices;
    private Status status;
    private String note;
    private String receiveName;
    private String receivePhone;
    private String receiveAddress;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String createDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String receiveDate;

}
