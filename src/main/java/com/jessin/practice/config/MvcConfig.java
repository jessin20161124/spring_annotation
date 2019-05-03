package com.jessin.practice.config;

import com.jessin.practice.controller.ControllerExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 只扫描@Controller的bean，并启动常用spring mvc注解，与<mvc:annotation-driven/>等价
 * @author zexin.guo
 * @create 2019-05-03 上午11:44
 **/
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.jessin.practice",
        includeFilters = {@ComponentScan.Filter(Controller.class)})
public class MvcConfig {
    /**
     * 注入全局处理器
     * @return
     */
    @Bean
    public HandlerExceptionResolver handlerExceptionResolver() {
        return new ControllerExceptionHandler();
    }
}
