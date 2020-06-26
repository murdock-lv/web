package com.bla.laa.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String indexAsHTML() {
        return "<html>\n" +
                "<header><title>Welcome</title>" +
                "</header>\n" +
                "<body>\n" +
                    "<a href=\"/nav/id-100000000\">LV</a> \n" +
                "</body>\n" +
                "</html>";
    }

}
