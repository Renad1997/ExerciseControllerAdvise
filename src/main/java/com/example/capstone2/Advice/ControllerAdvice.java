package com.example.capstone2.Advice;

import com.example.capstone2.Api.ApiException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException(ApiException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class) //endpoints:getUserByRole,updateStatus,
   public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e){
       String message = e.getMessage();
       return ResponseEntity.status(400).body(message);
   }

   @ExceptionHandler(value = NoResourceFoundException.class)//endpoints:getUserByRole,getUserById,changeUserPassword,isUserExist,isEmailExist,getNonActiveUser,getOrderByUserId,updateStatus,getOrdersByStatus,getProductsRate,getProductByCategoryId,getCategoryByType,getAddressByCity,getAddressByDistrict
  public ResponseEntity NoResourceFoundException(NoResourceFoundException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
  }

  @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class) //endpoints:changeUserPassword,isUserExist,isEmailExist,getNonActiveUser,updateStatus,getOrdersByStatus
public ResponseEntity HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
}

@ExceptionHandler(value = MethodArgumentTypeMismatchException.class) //endpoints:changeUserPassword,isUserExist,isEmailExist,getNonActiveUser,getOrderByUserId,updateStatus,getOrdersByStatus,getProductsRate,getProductByCategoryId,getCategoryByType,getAddressByCity,getAddressByDistrict
public ResponseEntity MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
}



}
