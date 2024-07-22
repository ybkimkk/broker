package com.am.broker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String forex() {
        return "home/index";
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
