package com.example.md5_phoneshopdata.modules.product;

import jakarta.persistence.*;
import lombok.*;
import com.example.md5_phoneshopdata.modules.category.Category;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sku;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String createDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String updateDate;

}
