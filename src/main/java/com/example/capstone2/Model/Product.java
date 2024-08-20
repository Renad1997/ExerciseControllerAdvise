package com.example.capstone2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @NotEmpty(message = "productName should be not empty")
    @Size(min = 4,message = "name must be more than 4 characters")
    @Column(columnDefinition = "varchar(20) not null")
    private String productName;

    @NotEmpty(message = "productDescription should be not empty")
    @Column(columnDefinition = "varchar(100) not null")
    private String productDescription;

    @Positive(message = "productPrice have to be positive")
    @Column(columnDefinition = "int")
    private int productPrice;

    @Column(columnDefinition = "double")
    private double productRate;

    @NotNull(message = "categoryId should be not Null!")
    @Column(columnDefinition = "int not null")
    private Integer categoryId; //FK



}
