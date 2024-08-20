package com.example.capstone2.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.DialectOverride;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotEmpty(message = "userName should be not Empty!")
    @Size(min = 5,message = "username have to be more than 5 characters")
    @Pattern(regexp="^[A-Za-z]*$" , message = " Name Must contain only characters no numbers")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String userName;

    @NotEmpty(message = "password should be not Empty!")
    @Pattern(regexp = "(^(?:(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*)[^\\s]{8,}$)",message = "password must contain 8 characters and digits")
    @Column(columnDefinition = "varchar(15) not null")
    private String password;

    @NotEmpty(message = "phoneNumber should be not Empty!")
    @Pattern(regexp = "(\05|0)[0-9]{9}",message = "Phone Number must start with '05' and have exactly 10 digits")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String phoneNumber;

    @NotEmpty(message = "Email should be not empty!")
    @Email(message = "Email must be valid email")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    @NotNull(message = "Age should be Not Null !")
    @Positive(message = "Age must be a number")
    @Min(value = 18, message = "Age must be more than 17")
    @Column(columnDefinition = "int not null")
    private int age;

    @NotEmpty(message = "Role should be not empty!")
    @Pattern(regexp="^(Admin|Customer)$",message = "Role must to be Admin or Customer")
//    @Column(columnDefinition = "varchar(20) not null")
// @Check(constraints ="role In('Admin','Customer')")
    private String role;

    @NotNull(message = "Balance should be not Null!")
    @Positive(message = "Balance have to be positive")
    @Column(columnDefinition = "int not null")
    private int balance;

}
