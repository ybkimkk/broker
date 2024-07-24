package com.am.broker.advice;

import com.am.broker.utils.MessageUtils;
import com.am.broker.utils.ServletUtils;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
        Map<String, String> menu = MessageUtils.searchMessages("menu");
        model.addAttribute("menu", menu);
        Map<String, String> footer = MessageUtils.searchMessages("footer");
        model.addAttribute("footer", footer);
        Map<String, String> common = MessageUtils.searchMessages("common");
        model.addAttribute("common", common);
        model.addAttribute("selectedLanguage", lang);
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
