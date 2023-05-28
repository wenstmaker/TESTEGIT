package com.example.internetstore.mapper;

import com.example.internetstore.Entity.Cart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public interface CartMapper {
    Integer Insert(Cart cart);

    Integer UpdateCart( @Param("cid") Integer cid,
                        @Param("num") Integer num,
                        @Param("modifiedUser") String modifiedUser,
                        @Param("modifiedTime") Date modifiedTime);

    Cart findByPidandUid( @Param("pid")Integer pid, @Param("uid")Integer Uid);

}
