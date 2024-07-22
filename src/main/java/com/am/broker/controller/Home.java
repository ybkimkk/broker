package com.am.broker.controller;


import com.am.broker.controller.common.CommonController;
import com.am.broker.utils.MessageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jinyongbin
 */
@Controller
@RequestMapping("/")
public class Home extends CommonController {

    @GetMapping
    public String index(HttpServletRequest request, Model model) {
//        String message = MessageUtils.message("menu.home");
        return "home/index";
    }
//
//    @GetMapping("login")
//    public String login() {
//        return "login";
//    }


    @PostMapping("changeLanguage")
    @ResponseBody
    public void changeLanguage(@RequestParam("lang") String lang) {
         MessageUtils.updateLanguage(lang);
    }
}
