package com.yunchun.config;

import com.yunchun.interceptor.Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Resource
    private Interceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
//                .addPathPatterns("/syscode/**")
//                .addPathPatterns("/syscode/add")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/style.css")
                .excludePathPatterns("/garden-contact.html")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/fonts/**")
                .excludePathPatterns("/upload/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/index")
                .excludePathPatterns("/loginCheck")
                .excludePathPatterns("/member/add")
                .excludePathPatterns("/article/index");

    }
}
