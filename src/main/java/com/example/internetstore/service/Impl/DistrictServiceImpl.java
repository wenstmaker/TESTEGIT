package com.example.internetstore.service.Impl;

import com.example.internetstore.Entity.District;
import com.example.internetstore.mapper.DistrictMapper;
import com.example.internetstore.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    @Override
    public List<District> findByParent(Integer Parent) {
        List<District> list = districtMapper.fingByParent(Parent);
        return list;
    }

    @Override
    public String findBycode(String code) {
        return districtMapper.findBycode(code);
    }
}
