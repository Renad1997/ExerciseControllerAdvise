package com.example.capstone2.Controller;

import com.example.capstone2.Model.Category;
import com.example.capstone2.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity getCategory() {
        return ResponseEntity.status(200).body(categoryService.getCategory());
    }

    @PostMapping("/add")
    public ResponseEntity addCategory(@Valid @RequestBody Category category) {
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body("Category Added");
    }

    @PutMapping("/update/{categoryId}")
    public ResponseEntity updateCategory(@PathVariable Integer categoryId,@Valid @RequestBody Category category){
        categoryService.updateCategory(categoryId,category);

        return ResponseEntity.status(200).body("Category Updated");
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity deleteCategory(@PathVariable Integer categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.status(200).body("Category Deleted");
    }

    @GetMapping("/get/category/{type}")
    public ResponseEntity getCategoryByType(@PathVariable String type) {  //12-endpoint
        return ResponseEntity.status(200).body(categoryService.getCategoryByType(type));
    }

}
