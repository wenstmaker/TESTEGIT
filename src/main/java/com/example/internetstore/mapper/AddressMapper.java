package com.example.internetstore.mapper;

import com.example.internetstore.Entity.Address;
import com.example.internetstore.Entity.District;

import java.util.List;

public interface AddressMapper {
    Integer insert(Address address);

    Integer countByUid(Integer uid);

    List<Address> findByUid(Integer uid);

    Integer UpdateDefaultAddress( Integer aid);

    Integer updateNonDefaultByUid(Integer uid);

    Integer deleteByAid(Integer aid);
}
