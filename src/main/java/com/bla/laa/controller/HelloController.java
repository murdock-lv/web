package com.bla.laa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public ModelAndView printHello() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", "hello world");
        return  modelAndView;

    }

}


