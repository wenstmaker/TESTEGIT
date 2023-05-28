package com.example.internetstore.service;

import com.example.internetstore.Entity.Address;
import com.example.internetstore.Entity.District;
import com.example.internetstore.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AddressService {


    void insertAddress(Integer Uid,String username,Address address);

    List<Address> findByUid(Integer uid);

    void updateDefaultAddress(Integer uid,Integer aid);

    void deleteByAid(Integer aid);

}
