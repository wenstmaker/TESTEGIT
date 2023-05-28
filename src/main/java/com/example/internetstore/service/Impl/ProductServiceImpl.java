package com.example.internetstore.service.Impl;

import com.example.internetstore.Entity.Product;
import com.example.internetstore.mapper.ProductMapper;
import com.example.internetstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> findHostList() {
        return productMapper.findHostList();
    }
}
