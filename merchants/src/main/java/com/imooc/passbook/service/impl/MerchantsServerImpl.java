package com.imooc.passbook.service.impl;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.constant.Constants;
import com.imooc.passbook.constant.ErrorCode;
import com.imooc.passbook.dao.MerchantsDao;
import com.imooc.passbook.entity.Merchants;
import com.imooc.passbook.service.IMerchants;
import com.imooc.passbook.vo.CreateMerchantsRequest;
import com.imooc.passbook.vo.CreateMerchantsResponse;
import com.imooc.passbook.vo.PassTemplate;
import com.imooc.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

// 商户服务接口实现
@Service
@Slf4j
public class MerchantsServerImpl   implements IMerchants{

    // Merchants 数据库接口
    private final MerchantsDao  merchantsDao ;

    //  kafka 客户端
    private final   KafkaTemplate<String,String>   kafkaTemplate ;

    public MerchantsServerImpl(MerchantsDao merchantsDao, KafkaTemplate <String, String> kafkaTemplate) {
        this.merchantsDao = merchantsDao;
        this.kafkaTemplate = kafkaTemplate;
    }

    //  @Transactional              // 事务存在    可以检测到是test 属性时，
    // 打印输出但是将存储在数据库的数据回滚，表示只测试
    public Response creatMerchantsRequest(CreateMerchantsRequest request) {

        Response response = new Response();
        CreateMerchantsResponse merchantsResponse = new CreateMerchantsResponse();
        ErrorCode  errorCode = request.validate(merchantsDao);

        if (errorCode!=ErrorCode.SUCCESS){   // 出错
            merchantsResponse.setId(-1);
            response.setErrorCode(errorCode.getCode());     // 告诉商户哪里出错
            response.setErrorMsg(errorCode.getDesc());
        }else {                                 //
            merchantsResponse.setId(merchantsDao.save(request.toMerchants()).getId());
        }                 //
        response.setData(merchantsResponse);
        return response;
    }

    @Override
    public Response buildMerchantsInfoById(Integer id) {
        Response  response = new Response();
        Merchants  merchants = merchantsDao.findById(id);
        if (null == merchants){
            response.setErrorCode(ErrorCode.MERCHANTS_NOT_EXIST.getCode());
            response.setErrorMsg(ErrorCode.MERCHANTS_NOT_EXIST.getDesc());
        }
        // 出错返回出错信息    复制返回respones 对象
        response.setData(merchants);
        return response;
    }

    @Override
    public Response dropPassTemplate(PassTemplate template) {
        Response  response = new Response();
        ErrorCode  errorCode = template.volidate(merchantsDao);

        if (errorCode != ErrorCode.SUCCESS){
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        }else {
            String passtemplate = JSON.toJSONString(template);
            kafkaTemplate.send(
                    Constants.TEMPLATE_TOPIC,
                    Constants.TEMPLATE_TOPIC,
                    passtemplate
            );
            log.info("DropPassTemplate:{} ",passtemplate);
        }

        return response;
    }

}
