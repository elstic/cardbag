package com.imooc.passbook;

import com.imooc.passbook.security.AuthCheckInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;

@SpringBootApplication    // 入口
public class MerchantsApplication  extends WebMvcConfigurerAdapter{

	@Resource    // 注入 Bean
	private AuthCheckInterceptor  authCheckInterceptor ;

	public static void main(String[] args) {
		SpringApplication.run(MerchantsApplication.class, args);
	}

	 // 重写的方法
	//  拦截器
	public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(authCheckInterceptor)
					.addPathPatterns("/merchants/**");
			// 以merchants 开头的方法都会被拦截
		super.addInterceptors(registry);
	}
}
