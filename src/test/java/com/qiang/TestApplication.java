package com.qiang;

import com.qiang.demo.entity.Area;
import com.qiang.demo.service.AreaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author gengqiang
 * @date 2018/5/4
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplication {

    @Autowired
    private AreaService areaService;


    @Test
    public void contextLoads() throws Exception {
        try {
            areaService.insertBack();

        } catch (Exception e) {
//            e.printStackTrace();
        }
        System.out.println(areaService.count(new Area()));

    }

    @Test
    public void test() {
        Area area = new Area();
        area.setDistrictId("0000");
        area.setName("test");
        area.setParentId(0);
        area.setLevel(1);
        areaService.insert(area);
    }

    @Test
    public void test2() {
        areaService.selectByPrimaryKey(1);
    }
}
