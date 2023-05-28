package com.example.internetstore.service.Impl;

import com.example.internetstore.Entity.Cart;
import com.example.internetstore.mapper.CartMapper;
import com.example.internetstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartmapper;

    @Override
    public void Insert(Integer uid,Integer pid,Integer num,String username) {
        Cart cart = cartmapper.findByPidandUid(pid,uid);
        if(cart == null){
            cart.setNum(num);
            cart.setCreatedUser(username);

        }
    }

    @Override
    public void updateNum(Integer cid, Integer num, String modifiedUser, Date modifiedTime) {
        cartmapper.UpdateCart(cid, num, modifiedUser, modifiedTime);
    }

    @Override
    public Cart GetCartByUidAndCid(Integer pid, Integer uid) {
        return cartmapper.findByPidandUid(pid,uid);
    }
}
