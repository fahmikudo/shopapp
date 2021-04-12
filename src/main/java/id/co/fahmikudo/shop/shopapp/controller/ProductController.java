package id.co.fahmikudo.shop.shopapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import id.co.fahmikudo.shop.shopapp.entity.Product;
import id.co.fahmikudo.shop.shopapp.service.ProductService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/product")
	public Mono<ResponseEntity<Product>> createPerson(@RequestBody Product productRequest) {
		return productService.createProduct(productRequest);
	}

    @GetMapping(value = "/product/{productId}")
    public Mono<ResponseEntity<Product>> getProductById(@PathVariable(value = "productId") String productId){
        return productService.getProductById(productId);
    }

    @PutMapping(value = "/product/{productId}")
    public Mono<ResponseEntity<Product>> updateProduct(@PathVariable(value = "productId") String productId, @RequestBody Product product){
        return productService.updateProduct(productId, product);
    }

    @DeleteMapping(value = "/product/{productId}")
    public Mono<ResponseEntity<Void>> deleteProduct(@PathVariable(value = "productId") String productId){
        return productService.deleteProduct(productId);
    }

    @GetMapping(value = "/product")
    public Flux<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping(value = "/product/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> streamAllProduct(){
        return productService.getAllProduct();
    }

}
