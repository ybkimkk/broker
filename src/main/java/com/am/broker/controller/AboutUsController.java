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
@RequestMapping
public class AboutUsController {
    @GetMapping("/*/aboutUs")
    public String contact(Model model) {
        Map<String, String> aboutUs = MessageUtils.searchMessages("aboutUs");
        model.addAttribute("aboutUs", aboutUs);
        return "aboutUs/index";
    }

    @GetMapping("/*/tradingMarkets")
    public String tradingMarkets(Model model) {
        Map<String, String> aboutUs = MessageUtils.searchMessages("aboutUs");
        model.addAttribute("aboutUs", aboutUs);
        return "tradingMarkets/index";
    }

    @GetMapping("/*/licenses")
    public String licenses(Model model) {
        Map<String, String> licenses = MessageUtils.searchMessages("licenses");
        model.addAttribute("licenses", licenses);

        Map<String, String> aboutUs = MessageUtils.searchMessages("aboutUs");
        model.addAttribute("aboutUs", aboutUs);
        return "licenses/index";
    }
}
