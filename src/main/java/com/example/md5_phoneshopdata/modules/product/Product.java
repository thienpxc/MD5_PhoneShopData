package com.example.md5_phoneshopdata.modules.product;

import com.example.md5_phoneshopdata.modules.category.Category;

import jakarta.persistence.*;
import lombok.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String images;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String createDate ;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String updateDate;
    private boolean status = true;

}
