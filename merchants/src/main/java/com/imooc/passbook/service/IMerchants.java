package com.imooc.passbook.service;

import com.imooc.passbook.vo.CreateMerchantsRequest;
import com.imooc.passbook.vo.PassTemplate;
import com.imooc.passbook.vo.Response;

//  商户子系统
public interface IMerchants {

    /*
        @param request {@link }   创建商户请求
      */
    Response  creatMerchantsRequest(CreateMerchantsRequest  request);

    //  根据 id 构造商户信息
    Response  buildMerchantsInfoById(Integer  id);

    //  投放优惠券       优惠券对象
    Response  dropPassTemplate(PassTemplate  passTemplate) ;
}
