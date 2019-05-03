package com.jessin.practice.controller;

import com.jessin.practice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jessin on 17-7-22.
 */
@Controller
public class HelloController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String sayHello(@RequestParam Integer one){
        return "input : " + one;
    }

    @RequestMapping(value = "/world", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, Integer> sayWorld(@RequestParam Integer one){
        Map<String, Integer> result = new HashMap<>(1);
        result.put("你输入了：", one);
        return result;
    }

    @RequestMapping(value = "/name", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String sayName(){
        return userService.getName();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String  error() {
        return "error";
    }
}
