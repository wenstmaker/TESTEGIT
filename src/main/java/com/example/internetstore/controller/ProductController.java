package com.example.internetstore.controller;

import com.example.internetstore.Entity.Product;
import com.example.internetstore.service.ProductService;
import com.example.internetstore.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController extends BaseController {
    @Autowired
    private ProductService productService;

    @RequestMapping("hot_list")
    public JsonResult<List<Product>> findHostList(){
       List<Product> list = productService.findHostList();
        return new JsonResult<List<Product>>(OK,list);
    }

}
