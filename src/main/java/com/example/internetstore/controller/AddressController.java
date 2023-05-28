package com.example.internetstore.controller;

import com.example.internetstore.Entity.Address;
import com.example.internetstore.service.AddressService;
import com.example.internetstore.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("addresses")
public class AddressController extends BaseController {
    @Autowired
    private AddressService addressService;

    @RequestMapping("add_new_address")
    public JsonResult<Void> CreateAddress(HttpSession session, Address address){
        String username = getUsernameFromSession(session);
        Integer uid = getUidFromSession(session);
        System.out.println(address);
        addressService.insertAddress(uid,username,address);
        return new JsonResult<Void>(200);
    }

    @GetMapping({"", "/"})
    public JsonResult<List<Address>> getByUid(HttpSession session) {
        Integer uid = getUidFromSession(session);
        List<Address> data = addressService.findByUid(uid);
        return new JsonResult<List<Address>>(OK, data);
    }

    @RequestMapping("{aid}/set_default")
    public JsonResult<Void> updateDefaultAddress(@PathVariable("aid") Integer aid, HttpSession session) {
        Integer uid = getUidFromSession(session);
       addressService.updateDefaultAddress(uid,aid);
        return new JsonResult<Void>(200);
    }

    @RequestMapping("{aid}/delete")
    public JsonResult<Void> deleteAddress(@PathVariable("aid") Integer aid) {

        String s = new String();
        System.out.println("hello wrid");
        addressService.deleteByAid(aid);
        return new JsonResult<Void>(200);
    }
}
