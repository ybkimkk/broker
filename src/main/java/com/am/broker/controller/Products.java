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
public class Products {
    @GetMapping("products")
    public String products() {
        return "home/index";
    }

    @GetMapping("forex")
    public String forex(Model model) {
        Map<String, String> home = MessageUtils.searchMessages("home");
        model.addAttribute("home", home);
        Map<String, String> forex = MessageUtils.searchMessages("forex");
        model.addAttribute("forex", forex);
        return "forex/index";
    }

    @GetMapping("stock")
    public String stock() {
        return "home/index";
    }

    @GetMapping("cryptocurrency")
    public String cryptocurrency() {
        return "home/index";
    }

    @GetMapping("cfds")
    public String cfds() {
        return "home/index";
    }

    @GetMapping("metals")
    public String metals() {
        return "home/index";
    }

    @GetMapping("indices")
    public String indices() {
        return "home/index";
    }

    @GetMapping("commodities")
    public String commodities() {
        return "home/index";
    }
}
