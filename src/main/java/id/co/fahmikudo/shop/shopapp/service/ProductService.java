package id.co.fahmikudo.shop.shopapp.service;

import org.springframework.http.ResponseEntity;

import id.co.fahmikudo.shop.shopapp.entity.Product;
import reactor.core.publisher.Mono;

public interface ProductService {
    
    Mono<ResponseEntity<?>> createProduct(Product product);

}
