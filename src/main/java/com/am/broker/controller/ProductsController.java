package com.am.broker.controller;

import com.alibaba.fastjson2.JSON;
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
public class ProductsController {
    @GetMapping("/*/products")
    public String products(Model model) {
        Map<String, String> home = MessageUtils.searchMessages("home");
        model.addAttribute("home", home);
        return "home/index";
    }

    @GetMapping("/*/forex")
    public String forex(Model model) {
        Map<String, String> forex = MessageUtils.searchMessages("forex");
        model.addAttribute("forex", forex);
        return "forex/index";
    }

    @GetMapping("/*/stock")
    public String stock(Model model) {
        Map<String, String> stock = MessageUtils.searchMessages("stock");
        model.addAttribute("stock", stock);
        return "stock/index";
    }

    @GetMapping("/*/cryptocurrency")
    public String cryptocurrency(Model model) {
        Map<String, String> cryptocurrency = MessageUtils.searchMessages("cryptocurrency");
        model.addAttribute("cryptocurrency", cryptocurrency);
        return "cryptocurrency/index";
    }

    @GetMapping("/*/cfds")
    public String cfds(Model model) {
        Map<String, String> cfds = MessageUtils.searchMessages("cfds");
        model.addAttribute("cfds", cfds);
        return "cfds/index";
    }

    @GetMapping("/*/metals")
    public String metals(Model model) {
        Map<String, String> metals = MessageUtils.searchMessages("metals");
        model.addAttribute("metals", metals);

        String reasons = MessageUtils.message("home.module9.2");
        model.addAttribute("reasons", reasons);

        Map<String, String> home = MessageUtils.searchMessages("home.module9");
        model.addAttribute("home", home);

        return "metals/index";
    }

    @GetMapping("/*/indices")
    public String indices(Model model) {
        Map<String, String> metals = MessageUtils.searchMessages("metals");
        model.addAttribute("metals", metals);

        Map<String, String> indices = MessageUtils.searchMessages("indices");
        model.addAttribute("indices", indices);

        Map<String, String> home = MessageUtils.searchMessages("home");
        model.addAttribute("home", home);
        String message = MessageUtils.message("indices.module7.table1");
        Object table1 = JSON.parse(message);
        model.addAttribute("table1", table1);

        return "indices/index";
    }

    @GetMapping("/*/commodities")
    public String commodities(Model model) {
        Map<String, String> commodities = MessageUtils.searchMessages("commodities");
        model.addAttribute("commodities", commodities);
        return "commodities/index";
    }
}
