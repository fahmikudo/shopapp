package id.co.fahmikudo.shop.shopapp.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import id.co.fahmikudo.shop.shopapp.entity.Item;

@Repository
public interface ItemRepository extends ReactiveMongoRepository<Item, String> {
    
}
