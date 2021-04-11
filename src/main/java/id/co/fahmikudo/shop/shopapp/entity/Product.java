package id.co.fahmikudo.shop.shopapp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class Product {
    
    @Id
    private String id;

    private String name;

    private String brand;

    private Long price;

}
