package com.example.capstone2.Repository;

import com.example.capstone2.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findOrderByOrderId(Integer orderId);

    List<Order> findOrderByUserId(Integer userId); //7-endpoint

    List<Order> findOrdersByOrderStatus(String status); //9-endpoint

}
