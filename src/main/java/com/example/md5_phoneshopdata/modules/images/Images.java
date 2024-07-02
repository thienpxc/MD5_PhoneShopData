package com.example.md5_phoneshopdata.modules.images;


import com.example.md5_phoneshopdata.modules.product.Product;
import jakarta.persistence.*;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String url;

    private String productImage;
    private boolean status = true;




}
