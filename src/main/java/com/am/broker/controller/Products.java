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
    @GetMapping("forex")
    public String forex() {
        return "index";
    }

    @GetMapping("stock")
    public String stock() {
        return "index";
    }

    @GetMapping("cryptocurrency")
    public String cryptocurrency() {
        return "index";
    }

    @GetMapping("cfds")
    public String cfds() {
        return "index";
    }

    @GetMapping("metals")
    public String metals() {
        return "index";
    }

    @GetMapping("indices")
    public String indices() {
        return "index";
    }

    @GetMapping("commodities")
    public String commodities() {
        return "index";
    }
}
