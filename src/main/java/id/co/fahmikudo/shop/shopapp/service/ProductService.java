package id.co.fahmikudo.shop.shopapp.service;

import org.springframework.http.ResponseEntity;

import id.co.fahmikudo.shop.shopapp.entity.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    
    Mono<ResponseEntity<Product>> createProduct(Product product);

    Mono<ResponseEntity<Product>> getProductById(String productId);

    Flux<Product> getAllProduct();

    Mono<ResponseEntity<Product>> updateProduct(String productId, Product product);

    Mono<ResponseEntity<Void>> deleteProduct(String productId);
}
