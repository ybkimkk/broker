package com.am.broker.controller;

import com.am.broker.utils.MessageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author jinyongbin
 * @version 1.0
 * @since 2024/7/15
 */
@Controller
@RequestMapping("/")
public class AboutUs {
    @GetMapping("aboutus")
    public String contact(Model model){
        Map<String, String> home = MessageUtils.searchMessages("home");
        model.addAttribute("home", home);
        return "home/index";
    }
}
