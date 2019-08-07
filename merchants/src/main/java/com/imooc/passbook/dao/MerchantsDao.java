package com.imooc.passbook.dao;

import com.imooc.passbook.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

// MerchantsDao 接口                   jpa 会自动帮助我们实现
public interface MerchantsDao  extends JpaRepository<Merchants,Integer>{
                                                   // Integer  是主键的类型
    /* 根据 id 获取商户对象
        @return {@link Merchants}
     */
    Merchants  findById(Integer  id);

    /*
        因为名称是唯一的   所以可以根据名称获取到唯一的商户对象
        @param name 商户名称
        @return {@link Merchants}
     */
    Merchants  findByName(String name);
}
