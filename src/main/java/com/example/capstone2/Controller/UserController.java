package com.example.capstone2.Controller;

import com.example.capstone2.Model.User;
import com.example.capstone2.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUser() {
        return ResponseEntity.status(200).body(userService.getUser());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.status(200).body("User Added");
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity updateUser(@PathVariable Integer userId,@Valid @RequestBody User user){
        userService.updateUser(userId,user);

        return ResponseEntity.status(200).body("User Updated");
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(200).body("User Deleted");
    }

    @GetMapping("/get/user/{role}")
    public ResponseEntity getUserByRole(@PathVariable String role) { // 1-endpoint
        List<User> u = userService.getUserByRole(role);
     return ResponseEntity.status(200).body(u);
    }

    @GetMapping("/get/user/by/{userId}")
    public ResponseEntity getUserById(@PathVariable Integer userId) { // 2-endpoint
   return ResponseEntity.status(200).body(userService.getUserById(userId));
    }

    @PutMapping("/update/pass/{userId}/{oldPass}/{newPass}")
    public ResponseEntity changeUserPassword(@PathVariable Integer userId,@PathVariable String oldPass,@PathVariable String newPass){ //3-endpoint
        int result = userService.changeUserPassword(userId,oldPass,newPass);
        if(result == 0){
            return ResponseEntity.status(200).body("User Password Changed");
        }else {
            return ResponseEntity.status(200).body("User Password doesn't match account");
        }
    }
    @GetMapping("/get/exist/{username}")
    public ResponseEntity isUserExist(@PathVariable String username){ // 4-endpoint
        return ResponseEntity.status(200).body(userService.isUserExist(username));
    }

    @GetMapping("/get/exists/{email}")
    public ResponseEntity isEmailExist(@PathVariable String email){  //5-endpoint
        return ResponseEntity.status(200).body(userService.isEmailExist(email));
    }

    @GetMapping("/get/non/active")
    public ResponseEntity getNonActiveUser(){  //6-endpoint
        return ResponseEntity.status(200).body(userService.getNonActiveUsers());
    }











}
