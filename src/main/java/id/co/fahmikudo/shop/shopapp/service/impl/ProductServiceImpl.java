package id.co.fahmikudo.shop.shopapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.co.fahmikudo.shop.shopapp.entity.Product;
import id.co.fahmikudo.shop.shopapp.exception.ErrorResponseException;
import id.co.fahmikudo.shop.shopapp.repository.ProductRepository;
import id.co.fahmikudo.shop.shopapp.service.ProductService;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Mono<ResponseEntity<?>> createProduct(Product product) {
        String productId = product.getId();
        return Mono.justOrEmpty(productId)
            .flatMap(id -> productRepository.existsById(id))
            .defaultIfEmpty(Boolean.FALSE)
            .flatMap(exists -> {
                if (exists) {
                    throw new ErrorResponseException(HttpStatus.BAD_REQUEST, "Id has been used.");
                }
                return productRepository.save(product).map(
                    saved -> {
                        return ResponseEntity.ok(product);
                    }
                );
            });
    }

    
}
