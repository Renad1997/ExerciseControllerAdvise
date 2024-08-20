package com.example.capstone2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    @NotEmpty(message = "city should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String city;

    @NotEmpty(message = "street should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String street;

    @NotEmpty(message = "district should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String district;

    @NotNull(message = "houseNumber should be not null")
    @Column(columnDefinition = "int not null")
    private int houseNumber;

    @NotNull(message = "requestId should be not null")
    @Column(columnDefinition = "int not null")
    private Integer userId; //FK



}
