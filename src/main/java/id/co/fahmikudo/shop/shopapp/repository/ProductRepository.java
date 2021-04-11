package id.co.fahmikudo.shop.shopapp.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import id.co.fahmikudo.shop.shopapp.entity.Product;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
    
}
