package com.am.broker.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String index() {
        System.out.println(1);
        System.out.println(2);

        return "index";
    }
}
