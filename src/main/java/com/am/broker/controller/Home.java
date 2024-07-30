package com.am.broker.controller;

import com.am.broker.utils.MessageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author jinyongbin
 */
@Controller
@RequestMapping("/")
public class Home {

    @GetMapping
    public String index(Model model) {
        Map<String, String> home = MessageUtils.searchMessages("home");
        model.addAttribute("home", home);
        return "home/index";
    }

    @PostMapping("changeLanguage")
    @ResponseBody
    public void changeLanguage(@RequestParam("lang") String lang) {
         MessageUtils.updateLanguage(lang);
    }
}
