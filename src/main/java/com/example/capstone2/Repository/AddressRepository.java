package com.example.capstone2.Repository;

import com.example.capstone2.Model.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Integer> {

    Address findAddressByAddressId(Integer addressId);

    @Query("select a from Address a where a.city=?1")  //13-endpoint
    List<Address> pleaseSearchAddressByCity(String city);

    @Query("select a from Address a where a.district=?1")  //14-endpoint
    List<Address> findAddressByDistrict(String district);




}
