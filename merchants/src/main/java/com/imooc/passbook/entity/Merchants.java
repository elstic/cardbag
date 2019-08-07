package com.imooc.passbook.entity;

/*
     商户对象模型
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data                    // 实现get   set
@NoArgsConstructor      // 无参构造器
@AllArgsConstructor     // 全参构造器
@Entity                 // 表明是实体对象
@Table(name = "merchants")
public class Merchants {

    // 商户 id    主键
    @Id
    @GeneratedValue
    @Column(name = "id" ,nullable = false)   // 列的属性是id   且是 not null 的
    private Integer  id;

    // 商户名称      全局唯一
    @Basic      // 表明是merchants 表的一个基本列
                // 和Basic 相对的是 transient  代表不是merchants表的属性
    @Column(name = "name" , unique = true ,nullable = false)    //   unique 全局唯一
    private String name ;

    //  商户 logo
    @Basic
    @Column(name = "logo_url",nullable = false)
    private String  logoUrl ;

    // 商户营业执照
    @Basic
    @Column(name = "business_license_url" , nullable = false)
    private String businessLicenseUrl ;

    // 商户联系电话
    @Basic
    @Column(name = "phone" , nullable = false)
    private String phone;

    // 商户地址
    @Basic
    @Column(name = "address" , nullable = false)
    private String address;


    // 是否通过审核
    @Basic
    @Column(name = "is_audit" , nullable = false)
    private Boolean isAudit = false;


}
