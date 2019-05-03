package com.jessin.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 只扫描@Controller的bean，并启动常用spring mvc注解，与<mvc:annotation-driven/>等价
 * 只扫描@Controller处理器，则必须设置useDefaultFilters=false，不要再扫描@Component
 *
 * @author zexin.guo
 * @create 2019-05-03 上午11:44
 **/
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.jessin.practice",
        useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(Controller.class)})
public class MvcConfig {
    /**
     * 注入自定义的异常处理器，不注入默认的
     *
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new LocalMvcConfigurerAdapter();
    }
}
