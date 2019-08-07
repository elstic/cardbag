package com.imooc.passbook.security;

import com.imooc.passbook.constant.Constants;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    拦截器   真正的实现权限校验
 */
@Component
public class AuthCheckInterceptor implements HandlerInterceptor{

    @Override    // http请求的前置拦截
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
       String  token = httpServletRequest.getHeader(Constants.TOKEN_STRING);

       if (StringUtils.isEmpty(token)){
           throw new Exception("Handler 中缺少"+Constants.TOKEN_STRING + " !");
       }

        if (!token.equals(Constants.TOKEN)){
            throw new Exception("Hander 中"+Constants.TOKEN_STRING+ "错误！");
        }

        AccessContext.setToken(token);   // 如果正确  将token set
                                        //  代表通过了拦截器的校验
        return true;
    }

    @Override   // http请求的后置拦截
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override    // 即使抛出异常，也代表这个 http 请求执行完毕
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse, Object o, Exception e) throws Exception {
        AccessContext.clearAccessKey();   // clear 清除请求信息
    }
}
