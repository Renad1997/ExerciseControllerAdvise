package com.example.capstone2.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Table(name = "Orders")
@Data
@Entity
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(columnDefinition = "int")
    private int price;

    @NotNull(message = "userId should be not null")
    @Column(columnDefinition = "int not null")
    private Integer userId; //FK

    @NotNull(message = "productId should be not null")
    @Column(columnDefinition = "int not null")
    private Integer productId; //FK

    @Pattern(regexp="^(pending|inProgress|destination country|order delivered)$",message = "orderStatus must to be pending or inProgress or destination country or order delivered")
    @Column(columnDefinition = "varchar(20)")
    private String orderStatus; //status:( pending , inProgress , destination country , order delivered)

    @JsonFormat(pattern ="yyyy-MM-dd")
    @PastOrPresent
    @Column(columnDefinition = "datetime default (CURRENT_TIMESTAMP)")
    private LocalDate orderDate;



}
