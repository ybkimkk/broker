package com.am.broker.controller;


import com.am.broker.controller.common.CommonController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jinyongbin
 */
@Controller
@RequestMapping("/")
public class Home extends CommonController {

    @GetMapping
    public String index(HttpServletRequest request, Model model) {
        return "home/index";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }
}
