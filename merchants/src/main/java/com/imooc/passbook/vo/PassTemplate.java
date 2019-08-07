package com.imooc.passbook.vo;


import com.imooc.passbook.constant.ErrorCode;
import com.imooc.passbook.dao.MerchantsDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    商户投放的优惠券信息
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplate {

    //   所属商品 id
    private Integer  id ;


    // 优惠券标题
    private String title;

    // 优惠券摘要
    private String  summary ;

    //  优惠券的详细信息
    private String  desc;

    // 最大个数限制
    private Long limit ;

    // 优惠券是否有 Token   用户商户核销
    private Boolean  hasToken ;     // Token 存储于 Redis Set 中   每次领取从redis 获取

    // 优惠券背景色
    private  Integer  background ;

    // 优惠劵开始时间
    private Data start ;

    // 优惠劵结束时间
    private Data  end;

    /*
         校验优惠券对象的有效性
     */
    public ErrorCode volidate(MerchantsDao merchantsDao) {

        if (merchantsDao.findById(id) == null)
            return ErrorCode.MERCHANTS_NOT_EXIST ;

        return ErrorCode.SUCCESS;
    }
}
