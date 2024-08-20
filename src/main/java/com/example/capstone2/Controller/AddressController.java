package com.example.capstone2.Controller;

import com.example.capstone2.Model.Address;
import com.example.capstone2.Model.Order;
import com.example.capstone2.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAddress() {
        return ResponseEntity.status(200).body(addressService.getAddress());
    }

    @PostMapping("/add")
    public ResponseEntity addAddress(@Valid @RequestBody Address address) {
        addressService.addAddress(address);
        return ResponseEntity.status(200).body("Address Added");
    }

    @PutMapping("/update/{addressId}")
    public ResponseEntity updateAddress(@PathVariable Integer addressId,@Valid @RequestBody Address address ){
        addressService.updateAddress(addressId,address);

        return ResponseEntity.status(200).body("Address Updated");
    }

    @DeleteMapping("/delete/{addressId}")
    public ResponseEntity deleteAddress(@PathVariable Integer addressId) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.status(200).body("Address Deleted");

    }

    @GetMapping("/get/address/{city}")
    public ResponseEntity getAddressByCity(@PathVariable String city) {  //13-endpoint
        List<Address> addressList = addressService.getAddressByCity(city);
        return ResponseEntity.status(200).body(addressList);
    }

    @GetMapping("/get/district/{district}")
    public ResponseEntity getAddressByDistrict(@PathVariable String district) { //14-endpoint
        List<Address> addressList = addressService.getAddressByDistrict(district);
        return ResponseEntity.status(200).body(addressList);
    }



}
