package modules.order;

import jakarta.persistence.*;
import lombok.*;
import modules.users.Users;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


public class Order {
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
