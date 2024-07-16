package com.am.broker.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jinyongbin
 */
@Controller
@RequestMapping("/")
public class Home {

    @GetMapping
    public String index(HttpServletRequest request) {
        return "index";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }
}
