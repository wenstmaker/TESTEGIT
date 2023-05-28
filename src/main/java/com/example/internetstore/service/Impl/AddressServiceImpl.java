package com.example.internetstore.service.Impl;

import com.example.internetstore.Entity.Address;
import com.example.internetstore.Entity.District;
import com.example.internetstore.mapper.AddressMapper;
import com.example.internetstore.mapper.DistrictMapper;
import com.example.internetstore.service.AddressService;
import com.example.internetstore.service.DistrictService;
import com.example.internetstore.service.exception.BeyongCountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressmapper;

    @Autowired
    private DistrictService districtService;

    @Value("${user.addressMax}")
    Integer MaxCount;

    @Override
    public void insertAddress(Integer uid,String username,Address address) {
        Integer count = addressmapper.countByUid(uid);
        if (count >= MaxCount) {
        throw new BeyongCountException("已存入20条，无法添加");
        }
        address.setUid(uid);
        address.setProvinceName(districtService.findBycode(address.getProvinceCode()));
        address.setAreaName(districtService.findBycode(address.getAreaCode()));
        address.setCityName(districtService.findBycode(address.getCityCode()));
        Integer IsDefault = count == 0 ? 1:0;
        address.setIsDefault(IsDefault);
        address.setCreatedUser(username);
        address.setModifiedUser(username);
        address.setModifiedTime(new Date());
        address.setCreatedTime(new Date());
        addressmapper.insert(address);
    }

    @Override
    public List<Address> findByUid(Integer uid) {
        List<Address> list = addressmapper.findByUid(uid);
        return list;
    }

    @Override
    public void updateDefaultAddress(Integer uid, Integer aid) {
        addressmapper.updateNonDefaultByUid(uid);
        addressmapper.UpdateDefaultAddress(aid);
    }

    @Override
    public void deleteByAid(Integer aid) {
        addressmapper.deleteByAid(aid);
    }


}
