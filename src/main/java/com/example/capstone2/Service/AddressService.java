package com.example.capstone2.Service;

import com.example.capstone2.Api.ApiException;
import com.example.capstone2.Model.Address;
import com.example.capstone2.Model.Order;
import com.example.capstone2.Model.User;
import com.example.capstone2.Repository.AddressRepository;
import com.example.capstone2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public List<Address> getAddress() {
        return (List<Address>) addressRepository.findAll();
    }

    public void addAddress(Address address){
        User user=userRepository.findUserByUserId(address.getUserId());
        if(user==null){
            throw new ApiException("UserId not found");
        }

        addressRepository.save(address);
    }

    public void updateAddress(Integer addressId ,Address address) {
        Address a = addressRepository.findAddressByAddressId(addressId);
        if(a==null){
            throw new ApiException("Address not found");
        }
      a.setCity(address.getCity());
      a.setStreet(address.getStreet());
      a.setDistrict(address.getDistrict());
      a.setHouseNumber(address.getHouseNumber());
      a.setUserId(address.getUserId());
        addressRepository.save(a);
    }

    public void deleteAddress(Integer addressId) {
        Address a = addressRepository.findAddressByAddressId(addressId);
        if(a==null){
            throw new ApiException("Address not found");
        }
        addressRepository.delete(a);
    }

    public List<Address> getAddressByCity(String city) {  //13-endpoint
        List<Address> a = addressRepository.pleaseSearchAddressByCity(city);
        if (a.isEmpty()) {
            throw new ApiException("Address not found");
        }
        return a;
    }

    public List<Address> getAddressByDistrict(String district) {  //14-endpoint
        List<Address> d = addressRepository.findAddressByDistrict(district);
        if (d.isEmpty()) {
            throw new ApiException("Address not found");
        }
        return d;
    }

}
