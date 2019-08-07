package com.imooc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
      通用的相应对象   在service 中进行值对象传递
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    // 错误码   如果正确返回 0
    private Integer  errorCode = 0 ;

    //  错误信息  正确返回空字符串
    private String errorMsg = "";

    // 返回给客户端的数据  值对象
    private Object data  ;

     // 正确的响应   构造函数
    public Response(Object data) {
        this.data = data;
    }
}