package com.imooc.passbook.service;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.vo.CreateMerchantsRequest;
import com.imooc.passbook.vo.PassTemplate;
import lombok.Data;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

//  商户服务测试类
@RunWith(SpringRunner.class)       // 不让是web 环境
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantsServTest {

    @Autowired
    private  IMerchants  merchantsServ ;

    @Test
//    @Transactional        // 次注解可以检测到是test 注解提供的，而不去想数据库数据插入
    public void testCreateMercahntsTest(){

        CreateMerchantsRequest request = new CreateMerchantsRequest();

        request.setName("慕容");
        request.setLogoUrl("wwww.imooc.com");
        request.setBusinessLicenseUrl("user.qzone.qq.com/2027017041");
        request.setPhone("1529174044*");
        request.setAddress("冰岛");
                        // JOSN 打出返回
        System.out.println(JSON.toJSONString(merchantsServ.creatMerchantsRequest(request)));
    }

    @Test
    public void testBuildMerchantsInfoById(){
        // 查询 id 为 9 的
        System.out.println(JSON.toJSONString(merchantsServ.buildMerchantsInfoById(9)));
    }

    @Test
    public void  testDropPassTemplate(){
        PassTemplate  passTemplate = new PassTemplate();
        passTemplate.setId(9);
        passTemplate.setTitle("title: 牛客");
        passTemplate.setSummary("简介： Boss直聘");
        passTemplate.setDesc("详情：拉钩");
        passTemplate.setLimit(10000L);    // long 类型
        passTemplate.setHasToken(false);
        passTemplate.setBackground(2);
        passTemplate.setStart((Data) new Date());
         passTemplate.setEnd((Data) DateUtils.addDays(new Date(),10));

        System.out.println(JSON.toJSONString(merchantsServ.dropPassTemplate(passTemplate)));
    }
}
