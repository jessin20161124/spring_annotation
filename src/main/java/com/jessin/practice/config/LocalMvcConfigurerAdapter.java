package com.jessin.practice.config;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author zexin.guo
 * @create 2019-05-03 下午4:25
 **/
public class LocalMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(new ControllerExceptionHandler());
    }
}
