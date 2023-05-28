package com.example.internetstore.mapper;

import com.example.internetstore.Entity.District;

import java.util.List;

public interface DistrictMapper {
    List<District> fingByParent(Integer parent);

    String findBycode(String code);
}
