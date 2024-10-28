package com.am.broker.controller;

import com.am.broker.utils.MessageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class ErrorController {
    @RequestMapping("/denied")
    public String contact(Model model) {
        Map<String, String> aboutUs = MessageUtils.searchMessages("aboutUs");
        return "denied/index";
    }
}
