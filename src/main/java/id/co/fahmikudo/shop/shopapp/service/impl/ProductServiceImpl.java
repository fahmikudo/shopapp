package id.co.fahmikudo.shop.shopapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.co.fahmikudo.shop.shopapp.entity.Product;
import id.co.fahmikudo.shop.shopapp.repository.ProductRepository;
import id.co.fahmikudo.shop.shopapp.service.ProductService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Mono<ResponseEntity<Product>> createProduct(Product product) {
        return productRepository.save(product)
            .map(p -> {
                return ResponseEntity.ok(p);
            }).defaultIfEmpty(
                new ResponseEntity<>(HttpStatus.NOT_FOUND)
            );
    }

    @Override
    public Mono<ResponseEntity<Product>> getProductById(String productId) {
        return productRepository.findById(productId)
            .map(p -> {
                return ResponseEntity.ok(p);
            }).defaultIfEmpty(
                new ResponseEntity<>(HttpStatus.NOT_FOUND)
            );
    }

    @Override
    public Flux<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Mono<ResponseEntity<Product>> updateProduct(String productId, Product product) {
        return productRepository.findById(productId)
            .flatMap(p -> {
                p.setName(product.getName());
                p.setBrand(product.getBrand());
                p.setPrice(product.getPrice());
                return productRepository.save(p);
            }).map(update -> {
                return ResponseEntity.ok(update);
            }).defaultIfEmpty(
                new ResponseEntity<>(HttpStatus.NOT_FOUND)
            );
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteProduct(String productId) {
        return productRepository.findById(productId)
            .flatMap(p ->
                productRepository.delete(p)
                    .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
            ).defaultIfEmpty(
                new ResponseEntity<>(HttpStatus.NOT_FOUND)
            );
    }

    

    

    
}
