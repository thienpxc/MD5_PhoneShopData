package com.example.md5_phoneshopdata.modules.product;

import com.example.md5_phoneshopdata.modules.category.Category;
import com.example.md5_phoneshopdata.modules.images.Images;
import com.example.md5_phoneshopdata.modules.product.product_ariant.ProductVariant;
import jakarta.persistence.*;
import lombok.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

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
    @OneToMany(mappedBy = "productVariant",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductVariant> variants;
    private String description;
    @OneToMany(mappedBy = "productImage", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Images> images;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date updateDate;
    private boolean status;

}
