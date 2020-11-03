package com.bla.laa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public ModelAndView printHello() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", "hello world");
        return  modelAndView;

    }

    @GetMapping("/static-2")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(
                "<!DOCTYPE html><html>" +
                        "<head>" +
                        "<meta charset=\"UTF-8\" />" +
                        "<title>HTML Rendered by Servlet</title>" +
                        "</head>" +
                        "<body>" +
                        "<h1>HTML Rendered by Servlet</h1></br>" +
                        "<p>This page was rendered by the ExampleOne Servlet!</p>" +
                        "</body>" +
                        "</html>"
        );
    }


}


