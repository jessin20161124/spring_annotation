package com.jessin.practice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 * app配置类入口，除了@Controller的注解的bean外，剩下的bean全部扫描进来
 * 这里把@Controller注解的bean、@configuration的bean排除掉，防止重复扫描
 * 注意exclude的优先级 > include
 *
 * @author zexin.guo
 * @create 2019-05-03 上午11:22
 **/
@Configuration
@ComponentScan(basePackages = "com.jessin.practice",
        excludeFilters = {
                @ComponentScan.Filter(value = {Controller.class, Configuration.class})
        }
)
public class AppConfig {
}
