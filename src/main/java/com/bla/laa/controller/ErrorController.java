package com.bla.laa.controller;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@Controller
public class ErrorController {

    @RequestMapping("/error-throw")
    public void errorThrow() throws Exception {
        throw new Exception("My exception");
    }

    @RequestMapping("/400")
    public void error400() throws Exception {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to find resource");
    }

}
