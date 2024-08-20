package com.example.capstone2.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import com.example.capstone2.Api.ApiException;
import com.example.capstone2.Model.Order;
import com.example.capstone2.Model.User;
import com.example.capstone2.Repository.OrderRepository;
import com.example.capstone2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Integer userId ,User user) {
        User u = userRepository.findUserByUserId(userId);
        if(u==null){
            throw new ApiException("User not found");
        }
        u.setUserName(user.getUserName());
        u.setPassword(user.getPassword());
        u.setPhoneNumber(user.getPhoneNumber());
        u.setEmail(user.getEmail());
        u.setAge(user.getAge());
        u.setRole(user.getRole());
        u.setBalance(user.getBalance());
        userRepository.save(u);
    }

    public void deleteUser(Integer userId) {
        User u = userRepository.findUserByUserId(userId);
        if(u==null){
            throw new ApiException("User not found");
        }
        userRepository.delete(u);
    }

    // this endpoint get list of users by specific role.
    public List<User> getUserByRole(String role) { // 1-endpoint
      List<User>  u =userRepository.findUserByRole(role);
      if(u.isEmpty()){
          throw new ApiException("User by role not found");
      }
      return u;
    }

    // this endpoint get user by id.
    public User getUserById(Integer userId) { // 2-endpoint
        User u = userRepository.findUserByUserId(userId);
        if(u==null){
            throw new ApiException("User by id not found");
        }
        return u;
    }
    // this endpoint make user to change your password if password matches old password.
    public int changeUserPassword(Integer userId,String oldPass,String newPass) { // 3-endpoint
        User u = userRepository.findUserByUserId(userId);
        if(u==null){
            throw new ApiException("password not change");
        }
        if(u.getPassword().equals(oldPass)){
            u.setPassword(newPass);
            userRepository.save(u);
            return 0 ;
        }else{
            return 1;
        }
    }
    //this endpoint check if username is existed in the system.
    public boolean isUserExist(String userName) { //4-endpoint
       User u =userRepository.findUserByUserName(userName);
      return u!=null;
    }

   //this endpoint check if email is existed in the system.
    public boolean isEmailExist(String email) { //5-endpoint
        User u=userRepository.isEmailExist(email);
        return u!=null;
    }
    //this endpoint get non-active user with more than 3 months.
    public List<User> getNonActiveUsers() {   //6-endpoint
        List<Order> orders = orderRepository.findAll();
        LocalDate currentDate = LocalDate.now();
        LocalDate dateThreeMonthsAgo = currentDate.minus(3, ChronoUnit.MONTHS);
        HashSet<Integer> preOrders = new HashSet<Integer>();
        HashSet<Integer> postOrders = new HashSet<Integer>();
        List<User> temp = new ArrayList<>();
        for (Order o : orders) {
            if (o.getOrderDate() != null) {
                if (o.getOrderDate().getMonthValue() <= dateThreeMonthsAgo.getMonthValue()) {
                    preOrders.add(o.getUserId());

                } else {
                    postOrders.add(o.getUserId());
                }
            }

        }
        preOrders.removeAll(postOrders);
        for (int o : preOrders) {
            User user = userRepository.findUserByUserId(o);
            temp.add(user);
        }
        return temp;

    }



}
