package com.example.capstone2.Service;

import com.example.capstone2.Api.ApiException;
import com.example.capstone2.Model.Category;
import com.example.capstone2.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Integer categoryId  ,Category category) {
        Category c = categoryRepository.findCategoryByCategoryId(categoryId);
        if(c==null){
            throw new ApiException("Category not found");
        }
        c.setName(category.getName());
        c.setType(category.getType());
        categoryRepository.save(c);
    }

    public void deleteCategory(Integer categoryId ) {
        Category c = categoryRepository.findCategoryByCategoryId(categoryId);
        if(c==null){
            throw new ApiException("Category not found");
        }
        categoryRepository.delete(c);
    }

    public Category getCategoryByType(String type) {  //12-endpoint
        Category c = categoryRepository.findCategoryByType(type);
        if(c==null){
            throw new ApiException("Category not found");
        }
        return c;
    }



}
