package com.example.md5_phoneshopdata.modules.product.user.product_ariant;

import com.example.md5_phoneshopdata.modules.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductVariantImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;
    private String images;

    @Override
    public String toString() {
        return "ProductVariantImg{" +
                "id=" + id +
                ", product=" + product +
                ", images='" + images + '\'' +
                '}';
    }

}
