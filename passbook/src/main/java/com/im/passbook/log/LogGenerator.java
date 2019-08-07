package com.im.passbook.log;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>日志生成器</h1>

 */
@Slf4j
public class LogGenerator {

    /**
      生成 log

     userId 用户 id
      action 日志类型
      info 日志信息, 可以是 null
      */
    public static void genLog(HttpServletRequest request, Long userId, String action, Object info) {

        log.info(
                JSON.toJSONString(
                        new LogObject(action, userId, System.currentTimeMillis(), request.getRemoteAddr(), info)
                )
        );
    }
}
