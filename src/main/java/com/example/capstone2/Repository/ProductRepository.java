package com.example.capstone2.Repository;

import com.example.capstone2.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findProductByProductId(Integer productId);

    Product findProductByCategoryId(Integer categoryId); //11-endpoint






}
