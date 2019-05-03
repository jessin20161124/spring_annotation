package com.jessin.practice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 * app配置类入口，除了@Controller的注解的bean外，剩下的bean全部扫描进来
 * @author zexin.guo
 * @create 2019-05-03 上午11:22
 **/
@Configuration
@ComponentScan(basePackages = "com.jessin.practice",
        excludeFilters = {@ComponentScan.Filter(Controller.class)})
public class AppConfig {
}
