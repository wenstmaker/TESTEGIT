package com.example.internetstore.mapper;


import com.example.internetstore.Entity.Address;
import com.example.internetstore.Entity.District;
import com.example.internetstore.service.AddressService;
import com.example.internetstore.service.DistrictService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//@SpringBootTest：表示标注当前是一个测试类，不会随着项目一同打包
//@RunWith:表示启动这个单元测试类(单元测试类是不能够运行的)，需要传递一个参数，必须是SpringRunner的实例类型

@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictMapperTest {
    @Autowired
    private DistrictService districtService;
    /**
     * 单元测试：可以独立运行，不用启动整个项目，提升效率
     * 1、必须被@Test修士
     * 2、返回值类型必须是void
     * 3、方法参数列表不指定任何类型
     * 4、方法的访问修饰符必须是public
     */
    @Test
    public void findByParent(){
        Integer id = 86;
        List<District> list = districtService.findByParent(id);
        System.out.println(list);
    }
}
