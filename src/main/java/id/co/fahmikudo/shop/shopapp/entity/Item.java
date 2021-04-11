package id.co.fahmikudo.shop.shopapp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "item")
public class Item {
    
    @Id
    private String id;

    private String barcode;

    private String productId;

}
