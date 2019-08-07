package com.imooc.passbook.vo;
/*
       创建 metchants 的请求对象
 */

import com.imooc.passbook.constant.ErrorCode;
import com.imooc.passbook.dao.MerchantsDao;
import com.imooc.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsRequest {

    // 商户名称
    private  String  name ;

    // 商户 logo
    private String  logoUrl ;

    // 商户营业执照
    private String businessLicenseUrl ;

    // 商户联系电话
    private  String  phone  ;

    // 商户地址
    private  String  address ;

    /*
     *    <h2>验证请求的有效性</h2>
     *    @param merchantsDao  {@link MerchantsDao }
     *    @return  {@link}
     */



    public ErrorCode validate(MerchantsDao merchantsDao){
        // 判断这个request 对象的属性是否都存在
        if (merchantsDao.findByName(this.name)!= null)
            return ErrorCode.DUPLICATE_NAME ;
        if ( logoUrl == null)
            return ErrorCode.EMPTY_LOGO ;
        if (null == businessLicenseUrl )
            return ErrorCode.EMPTY_BUSINESS_LICENSE ;
        if (null == address)
            return  ErrorCode.EMPTY_ADDRESS  ;
        if (null == phone)
            return  ErrorCode.ERROR_PHONE ;
        return ErrorCode.SUCCESS ;
    }

    // 将请求对象转化为商户对象
     //   @return  {@link}
    public Merchants   toMerchants(){
        Merchants  merchants  = new Merchants() ;

        merchants.setName(name);
        merchants.setLogoUrl(logoUrl);
        merchants.setBusinessLicenseUrl(businessLicenseUrl);
        merchants.setPhone(phone);
        merchants.setAddress(address);

        return merchants ;
    }
}
