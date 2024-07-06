package com.example.md5_phoneshopdata.modules.product;

import com.example.md5_phoneshopdata.modules.category.Category;

import com.example.md5_phoneshopdata.modules.product.user.product_ariant.ProductVariant;
import com.example.md5_phoneshopdata.modules.product.user.product_ariant.ProductVariantImg;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import org.springframework.format.annotation.DateTimeFormat;

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
    @Column(length = 10000)
    private String description;
    private String storage;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String createDate ;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String updateDate;
    private boolean status = true;
    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<ProductVariant> productVariants;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<ProductVariantImg> productVariantImg;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", storage='" + storage + '\'' +
                ", category=" + category +
                ", createDate='" + createDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", status=" + status +
                ", productVariants=" + productVariants +
                ", productVariantImg=" + productVariantImg +
                '}';
    }

}
