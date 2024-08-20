package com.example.capstone2.Service;

import com.example.capstone2.Api.ApiException;
import com.example.capstone2.Model.Category;
import com.example.capstone2.Model.Product;
import com.example.capstone2.Model.User;
import com.example.capstone2.Repository.CategoryRepository;
import com.example.capstone2.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    public void addProduct(Product product){
        Category category=categoryRepository.findCategoryByCategoryId(product.getCategoryId());
        if(category==null){
            throw new ApiException("CategoryId not found");
        }
        productRepository.save(product);
    }

    public void updateProduct(Integer productId ,Product product) {
        Product p = productRepository.findProductByProductId(productId);
        if(p==null){
            throw new ApiException("Product not found");
        }
        p.setProductName(product.getProductName());
        p.setProductDescription(product.getProductDescription());
        p.setProductPrice(product.getProductPrice());
        p.setProductRate(product.getProductRate());
        p.setCategoryId(product.getCategoryId());
        productRepository.save(p);
    }

    public void deleteProduct(Integer productId) {
        Product p = productRepository.findProductByProductId(productId);
        if(p==null){
            throw new ApiException("Product not found");
        }
        productRepository.delete(p);
    }

// this endpoint get all products with rate more than or equal input rate.
    public List<Product> getProductRate(double productRate) {  //10-endpoint
      List<Product> temp=new ArrayList<>();
      List<Product> products=productRepository.findAll();
        for(Product p:products){
            if(p.getProductRate()>=productRate){
                temp.add(p);
            }
        }
        return temp;
    }

    public Product getProductByCategoryId(Integer categoryId) {  //11-endpoint
       Product p=productRepository.findProductByCategoryId(categoryId);
       if(p==null){
           throw new ApiException("Product not found");
       }
       return p;
    }


}
