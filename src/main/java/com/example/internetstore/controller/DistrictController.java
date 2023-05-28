package com.example.internetstore.controller;

import com.example.internetstore.Entity.District;
import com.example.internetstore.mapper.DistrictMapper;
import com.example.internetstore.service.DistrictService;
import com.example.internetstore.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("districts")
public class DistrictController extends BaseController{
    @Autowired
    private DistrictService districtService;
    @GetMapping({"", "/"})
    public JsonResult<List<District>> findByParent(Integer parent){
        System.out.println(parent);
        List<District> list = districtService.findByParent(parent);
        return new JsonResult<List<District>>(200,list);
    }
}
