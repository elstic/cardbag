package com.imooc.passbook.controller;


import com.alibaba.fastjson.JSON;
import com.imooc.passbook.service.IMerchants;
import com.imooc.passbook.vo.CreateMerchantsRequest;
import com.imooc.passbook.vo.PassTemplate;
import com.imooc.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// 商户服务 Ctl
@Slf4j
@RestController      // rest 风格的 ctl
@RequestMapping("/merchants")
public class MerchantsCtl {

    //  商户服务接口
    private  final IMerchants  merchantsServ ;

    @Autowired
    public MerchantsCtl(IMerchants merchantsServ) {
        this.merchantsServ = merchantsServ;
    }

    @PostMapping("/create")
    @ResponseBody    // 将 response 返回为一个字符串的对象     rest 风格的
    public Response createMerchants(@RequestBody CreateMerchantsRequest  request){
                //             能正确将前端请求返回的JSON 对象序列化为一个 request 对象
        log.info("Create Merchants :{}", JSON.toJSONString(request));
        return  merchantsServ.creatMerchantsRequest(request)   ;
    }

    @ResponseBody
    @GetMapping("/{id}")        // 动态的获取 id 而不是某个固定的 uri
    public  Response  buildMerchantsInfo(@PathVariable Integer  id){
                                //    因为是动态的uri 所以参数给一个 PathVariable 标识
        log.info("BuildMerchantsInfo:{}",id);
        return  merchantsServ.buildMerchantsInfoById(id);
    }

    @ResponseBody
    @PostMapping("/drop")
    public  Response  dropPassTemplate(@RequestBody PassTemplate  passTemplate){
        log.info("DropPassTemplate :{}",passTemplate);
        return merchantsServ.dropPassTemplate(passTemplate);
    }
}
