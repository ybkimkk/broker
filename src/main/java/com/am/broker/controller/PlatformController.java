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
public class PlatformController {
    @GetMapping("platform")
    public String plat(Model model){
        Map<String, String> home = MessageUtils.searchMessages("home");
        model.addAttribute("home", home);

        Map<String, String> platform = MessageUtils.searchMessages("platform");
        model.addAttribute("platform", platform);


        Map<String, String> metals = MessageUtils.searchMessages("metals");
        model.addAttribute("metals", metals);
        return "platform/index";
    }
}
