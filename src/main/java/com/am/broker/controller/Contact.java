package com.am.broker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jinyongbin
 * @version 1.0
 * @since 2024/7/15
 */
@Controller
@RequestMapping("/")
public class Contact {
    @GetMapping("contact")
    public String contact(){
        return "index";
    }
}
