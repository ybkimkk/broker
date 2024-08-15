package com.am.broker.advice;

import com.am.broker.utils.MessageUtils;
import com.am.broker.utils.ServletUtils;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author jinyongbin
 * @version 1.0
 * @since 2024/7/20
 */

@ControllerAdvice
public class GlobalControllerAdvice {
    private static LinkedHashMap<String, String> languageMap;

    @PostConstruct
    public void init() {
        languageMap = new LinkedHashMap<>();
        languageMap.put("en", "English");
        languageMap.put("in", "INDONESIA");
        languageMap.put("vn", "Tiếng Việt");
        languageMap.put("tc", "繁體中文");
        languageMap.put("ko", "한국어");
        languageMap.put("cn", "简体中文");
        languageMap.put("jp", "日本語");
        languageMap.put("ar", "بالعربية");
    }

    @ModelAttribute
    public void addAttributes(HttpServletRequest request, Model model) {
        String selectedLanguageKey = ServletUtils.getCookie(request, "lang");
        String selectedLanguageValue = languageMap.get(selectedLanguageKey);
        if (Objects.isNull(selectedLanguageValue)) {
            selectedLanguageKey = "en";
        }
        for (Map.Entry<String, String> stringStringEntry : languageMap.entrySet()) {
            model.addAttribute(stringStringEntry.getKey(), stringStringEntry.getValue());
        }
        Map<String, String> menu = MessageUtils.searchMessages("menu");
        model.addAttribute("menu", menu);
        Map<String, String> footer = MessageUtils.searchMessages("footer");
        model.addAttribute("footer", footer);
        Map<String, String> common = MessageUtils.searchMessages("common");
        model.addAttribute("common", common);
        model.addAttribute("selectedLanguageKey", selectedLanguageKey);
        model.addAttribute("languageMap", languageMap);
    }

    @ExceptionHandler(SpelEvaluationException.class)
    public ModelAndView handleNotFoundException() {
        // 创建一个ModelAndView对象，设置重定向视图
        ModelAndView modelAndView = new ModelAndView();
        // 设置重定向到首页
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
