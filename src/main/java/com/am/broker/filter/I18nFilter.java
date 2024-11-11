package com.am.broker.filter;

import cn.hutool.core.util.ArrayUtil;
import com.am.broker.utils.MessageUtils;
import com.am.broker.utils.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;

@Component
@WebFilter("/*")
@Order(2)
public class I18nFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(I18nFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String requestURI = httpRequest.getRequestURI();
        if (shouldFilter(httpRequest)) {
            String[] split = requestURI.split("/");
            if (ArrayUtil.isNotEmpty(split) && split.length >= 2) {
                LinkedHashMap<String, String> languageMap = MessageUtils.getLanguageMap();
                if (!languageMap.containsKey(split[1])) {
                    split[1] = MessageUtils.getCurrentLanguage();
                    httpResponse.sendRedirect(String.join("/", split));
                    return;  // 
                }
            }
        }

        filterChain.doFilter(httpRequest, httpResponse);
    }

    private boolean shouldFilter(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return !ServletUtils.checkStatic(request) &&
                !requestURI.equals("/block") &&
                !requestURI.equals("/denied");
    }
}
