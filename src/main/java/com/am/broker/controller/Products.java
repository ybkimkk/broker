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
    public String products(Model model) {
        Map<String, String> home = MessageUtils.searchMessages("home");
        model.addAttribute("home", home);
        return "home/index";
    }

    @GetMapping("forex")
    public String forex(Model model) {
        Map<String, String> forex = MessageUtils.searchMessages("forex");
        model.addAttribute("forex", forex);
        return "forex/index";
    }

    @GetMapping("stock")
    public String stock(Model model) {
        Map<String, String> stock = MessageUtils.searchMessages("stock");
        model.addAttribute("stock", stock);
        return "stock/index";
    }

    @GetMapping("cryptocurrency")
    public String cryptocurrency(Model model) {
        Map<String, String> cryptocurrency = MessageUtils.searchMessages("cryptocurrency");
        model.addAttribute("cryptocurrency", cryptocurrency);
        return "cryptocurrency/index";
    }

    @GetMapping("cfds")
    public String cfds(Model model) {
        Map<String, String> cfds = MessageUtils.searchMessages("cfds");
        model.addAttribute("cfds", cfds);
        return "cfds/index";
    }

    @GetMapping("metals")
    public String metals(Model model) {
        return "home/index";
    }

    @GetMapping("indices")
    public String indices(Model model) {
        return "home/index";
    }

    @GetMapping("commodities")
    public String commodities(Model model) {
        return "home/index";
    }
}
