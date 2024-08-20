package com.example.capstone2.Repository;

import com.example.capstone2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUserId(Integer userId); // 2 & 3-endpoint


    List<User> findUserByRole(String role); // 1-endpoint

    User findUserByUserName(String userName); // 4-endpoint

    @Query("select u from User u where u.email=?1") //5-endpoint
    User isEmailExist(String email);






}
