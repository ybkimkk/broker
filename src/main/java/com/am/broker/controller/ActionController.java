package com.am.broker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("do")
public class ActionController {
    @PostMapping("login")
    public String login() {
        return "redirect:/";
    }
}
