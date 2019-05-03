package com.jessin.practice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.Map;

/**
 * 只能处理处理器抛出的异常，如参数不匹配，
 * 对于/practice/xxx 404异常，通过web.xml中的DispatchServlet转化为异常进行处理
 * 如果不配置这个bean，则使用默认的DefaultHandlerExceptionHandler进行处理，这个不会把日志打出来，
 * 会展示400/404等页面。
 *
 * @author zexin.guo
 * @create 2018-08-04 上午10:35
 **/
@Slf4j
public class ControllerExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) {
        // 不使用MappingJacksonJsonView
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        Map<String, Object> msg = new HashMap();
        msg.put("error", ex.getMessage());
        msg.put("ret", "false");
        view.setExtractValueFromSingleKeyModel(true);
        ModelAndView mv = new ModelAndView();
        mv.setView(view);
        mv.addObject("sb", msg);
        log.error("出错了：", ex);
        return mv;
    }
}
