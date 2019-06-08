package com.cet.homework;


import com.cet.homework.interceptor.AdminInterceptor;
import com.cet.homework.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//王嘉奇
//web配置类，注册拦截器
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Autowired
    private AdminInterceptor adminInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注入拦截器
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/api/**")//拦截路径规则，login下的所有请求
                .excludePathPatterns("/api/login","/api/admin/register");//拦截排除规则
       registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/api/admin");
    }
}
