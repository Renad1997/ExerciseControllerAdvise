package com.example.capstone2.Controller;

import com.example.capstone2.Model.Category;
import com.example.capstone2.Model.Product;
import com.example.capstone2.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get")
    public ResponseEntity getProduct() {
        return ResponseEntity.status(200).body(productService.getProduct());
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody Product product) {
       productService.addProduct(product);
        return ResponseEntity.status(200).body("Product Added");
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity updateProduct(@PathVariable Integer productId,@Valid @RequestBody Product product){
        productService.updateProduct(productId,product);

        return ResponseEntity.status(200).body("Product Updated");
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.status(200).body("Product Deleted");
    }
    @GetMapping("/get/rate/{productRate}")
    public ResponseEntity getProductsRate(@PathVariable double productRate) { //10-endpoint
        List<Product> products=productService.getProductRate(productRate);
        return ResponseEntity.status(200).body(products);
    }

    @GetMapping("/get/product/{categoryId}")
    public ResponseEntity getProductByCategoryId(@PathVariable Integer categoryId) { //11-endpoint
        return ResponseEntity.status(200).body(productService.getProductByCategoryId(categoryId));
    }



}
