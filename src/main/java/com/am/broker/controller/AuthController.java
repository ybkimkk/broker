package com.am.broker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jinyongbin
 * @version 1.0
 * @since 2024/7/15
 */
@Controller
@RequestMapping("do")
public class AuthController {
    @PostMapping("login")
    public String login() {
        return "redirect:/";
    }
}
