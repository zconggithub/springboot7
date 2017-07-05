package com.example.demo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter{

	//注册拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		 // 多个拦截器组成一个拦截器链
		// addPathPatterns() 用于添加拦截规则,addPathPatterns("/**");//拦截所有请求
		 // excludePathPatterns() 用户排除拦截[// 配置不拦截的路径]
registry.addInterceptor(new MyIntercepter()).addPathPatterns("/Friend/**");//拦截所有请求
		// registry.addInterceptor(new MyIntercepter()).excludePathPatterns("/**/comment");//排除"comment"这个请求的拦截
		// registry.addInterceptor(new MyIntercepter()).addPathPatterns("/**").excludePathPatterns("/login");//拦截所有请求
		 super.addInterceptors(registry);  
		    
	}

	
	
}
  
    