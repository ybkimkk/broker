package com.am.broker.advice;

import com.am.broker.utils.ServletUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jinyongbin
 * @version 1.0
 * @since 2024/7/20
 */

@ControllerAdvice
public class GlobalControllerAdvice {
    @ModelAttribute
    public void addAttributes(HttpServletRequest request, Model model) {
        String lang = ServletUtils.getCookie(request, "lang");
        model.addAttribute("selectedLanguage", lang);
    }
}
