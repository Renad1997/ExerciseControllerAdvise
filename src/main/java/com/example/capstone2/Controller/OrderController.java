package com.example.capstone2.Controller;
import com.example.capstone2.Model.Order;
import com.example.capstone2.Service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/get")
    public ResponseEntity getOrder() {
        return ResponseEntity.status(200).body(orderService.getOrder());
    }

    @PostMapping("/add")
    public ResponseEntity addOrder(@Valid @RequestBody Order order) {
        orderService.addOrder(order);
        return ResponseEntity.status(200).body("Order Added");
    }

    @PutMapping("/update/{orderId}")
    public ResponseEntity updateOrder(@PathVariable Integer orderId,@Valid @RequestBody Order order){
        orderService.updateOrder(orderId,order);

        return ResponseEntity.status(200).body("Order Updated");
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity deleteOrder(@PathVariable Integer orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.status(200).body("Order Deleted");
    }
    @GetMapping("/get/order/{userId}")
    public ResponseEntity getOrderByUserId(@PathVariable Integer userId) { //7-endpoint
        List<Order> orders = orderService.getOrderByUserId(userId);
        return ResponseEntity.status(200).body(orders);
    }

    @PutMapping("/update/status/{orderId}/{status}")
    public ResponseEntity updateStatus(@PathVariable Integer orderId, @PathVariable String status) { //8-endpoint
      String message= orderService.updateStatus(orderId,status);
        return ResponseEntity.status(200).body(message);
    }

    @GetMapping("/get/order/status/{status}")
    public ResponseEntity getOrdersByStatus(@PathVariable String status){  //9-endpoint
        List<Order> orders = orderService.getOrdersByStatus(status);
       return ResponseEntity.status(200).body(orders);
    }






}
