package com.example.scai_yd_server.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * AJAX请求跨域
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    static final String ORIGINS[] = new String[] { "GET", "POST", "PUT", "DELETE" };

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //添加映射路径
        registry.addMapping("/**")
                //是否发送Cookie
                .allowCredentials(true)
                //设置放行哪些原始域   SpringBoot2.4.4下低版本使用.allowedOrigins("*")
                .allowedOriginPatterns("*")
                //放行哪些请求方式
                .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"})
                //.allowedMethods("*") //或者放行全部
                //放行哪些原始请求头部信息
                .allowedHeaders("*")
                //暴露哪些原始请求头部信息
                .exposedHeaders("*");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //总是报404是地址没印射对，addResourceHandler("/xixi/**")访问时不拦截的地址
        //addResourceLocations("file:C:/pdf/haha")指定文件夹
        //图片在磁盘的C:\pdf\haha
        registry.addResourceHandler("/upload/**").addResourceLocations("file:"+System.getProperty("user.dir")+"\\upload\\");
        //file:C:/pdf/haha/指向本地图片路径地址
    }
}