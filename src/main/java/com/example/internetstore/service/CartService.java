package com.example.internetstore.service;

import com.example.internetstore.Entity.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CartService {
    void Insert(Integer uid,Integer pid,Integer num,String username);

    void updateNum(Integer cid,
                    Integer num,
                    String modifiedUser,
                  Date modifiedTime);

    Cart GetCartByUidAndCid(Integer pid,Integer uid);
}
