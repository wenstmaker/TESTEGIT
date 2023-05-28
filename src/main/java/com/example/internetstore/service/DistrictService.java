package com.example.internetstore.service;

import com.example.internetstore.Entity.District;

import java.util.List;

public interface DistrictService {
    List<District> findByParent(Integer Parent);

    String findBycode(String code);
}
