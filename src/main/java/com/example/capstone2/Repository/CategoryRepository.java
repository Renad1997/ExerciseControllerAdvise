package com.example.capstone2.Repository;

import com.example.capstone2.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findCategoryByCategoryId(Integer categoryId);

    Category findCategoryByType(String type); //12-endpoint



}
