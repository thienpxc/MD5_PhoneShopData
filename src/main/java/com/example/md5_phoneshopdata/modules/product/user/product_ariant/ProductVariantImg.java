package com.example.md5_phoneshopdata.modules.product.user.product_ariant;

import com.example.md5_phoneshopdata.modules.product.Product;
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
    private Product productVariantImg;
    private String image;

}
