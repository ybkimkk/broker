package com.am.broker.advice;

import com.am.broker.utils.MessageUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * @author jinyongbin
 * @version 1.0
 * @since 2024/7/20
 */

@ControllerAdvice
public class GlobalControllerAdvice {


    @ModelAttribute
    public void addAttributes(HttpServletRequest request, Model model) {
        Map<String, String> menu = MessageUtils.searchMessages("menu");
        model.addAttribute("menu", menu);
        Map<String, String> footer = MessageUtils.searchMessages("footer");
        model.addAttribute("footer", footer);
        Map<String, String> common = MessageUtils.searchMessages("common");
        model.addAttribute("common", common);
        model.addAttribute("selectedLanguageKey", MessageUtils.getCurrentLanguage());
        model.addAttribute("languageMap", MessageUtils.getLanguageMap());
        model.addAttribute("isDesktop", isDesktop(request));
    }


    private boolean isDesktop(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        if (Objects.isNull(userAgent)) {
            return true;
        }

        String[] mobileKeywords = {"Mobile", "Android", "iPhone", "iPad", "iPod", "Windows Phone", "BlackBerry"};
        for (String keyword : mobileKeywords) {
            if (userAgent.contains(keyword)) {
                return false;
            }
        }
        return true;
    }
}
