package com.example.capstone2.Service;

import com.example.capstone2.Api.ApiException;
import com.example.capstone2.Model.Order;
import com.example.capstone2.Model.Product;
import com.example.capstone2.Model.User;
import com.example.capstone2.Repository.OrderRepository;
import com.example.capstone2.Repository.ProductRepository;
import com.example.capstone2.Repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;


    public List<Order> getOrder() {
        return orderRepository.findAll();
    }

    public void addOrder(Order order){
        User user = userRepository.findUserByUserId(order.getUserId());
        Product product=productRepository.findProductByProductId(order.getProductId());
        if(user==null || product==null){
            throw new ApiException("UserId or productId not found");
        }
        order.setOrderDate(LocalDate.now());
        order.setOrderStatus("pending");
        order.setPrice(product.getProductPrice());
        orderRepository.save(order);
    }

    public void updateOrder(Integer orderId ,Order order) {
        Order o = orderRepository.findOrderByOrderId(orderId);
        if(o==null){
            throw new ApiException("Order not found");
        }
        o.setPrice(order.getPrice());
        o.setUserId(order.getUserId());
        o.setProductId(order.getProductId());
        o.setOrderStatus(order.getOrderStatus());
        o.setOrderDate(order.getOrderDate());
        orderRepository.save(o);
    }

    public void deleteOrder(Integer orderId) {
        Order o = orderRepository.findOrderByOrderId(orderId);
        if(o==null){
            throw new ApiException("Order not found");
        }
        orderRepository.delete(o);
    }
    // this endpoint get all orders by user id.
    public List<Order> getOrderByUserId(Integer userId) {  //7-endpoint
        List<Order> orders = orderRepository.findOrderByUserId(userId);
        if(orders.isEmpty()){
            throw new ApiException("User id not found");
        }
        return orders;
    }

    // this endpoint update status based on order id and status.
    public String updateStatus(Integer orderId, String orderStatus){  //8-endpoint
        try {
            Order o = orderRepository.findOrderByOrderId(orderId);
            o.setOrderStatus(orderStatus);
            orderRepository.save(o);
            return "Order status updated";
        }catch (ApiException e){
            return e.getMessage();
        }
    }

    //this endpoint get all orders by status.
    public List<Order> getOrdersByStatus(String status) { //9-endpoint
    List<Order> o=orderRepository.findOrdersByOrderStatus(status);
      if(o.isEmpty()){
          throw new ApiException("Order status not found");
      }
      return o;
    }


}
