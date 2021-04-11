package id.co.fahmikudo.shop.shopapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import id.co.fahmikudo.shop.shopapp.entity.Product;
import id.co.fahmikudo.shop.shopapp.service.ProductService;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/product")
	public Mono<ResponseEntity<?>> createPerson(@RequestBody Product productRequest) {
		return productService.createProduct(productRequest);
	}


}
