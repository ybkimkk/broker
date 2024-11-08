package com.am.broker.controller;

import com.am.broker.utils.CacheUtil;
import com.am.broker.utils.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@Slf4j
public class CustomErrorController implements ErrorController {

    @Value("${block.count}")
    private Integer blockCount;


    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        String clientIp = ServletUtils.getClientIp(request);
        Integer count = CacheUtil.getCache(clientIp, Integer.class);
        count = Objects.isNull(count) ? 1 : ++count;

        log.info("ip: {},count:{}", clientIp, count);
        CacheUtil.addCache(clientIp, count);
        
        if (count >= blockCount) {
            return "redirect:/block";
        }

        return "redirect:/";
    }
}
