package com.am.broker.interceptor;

import com.am.broker.utils.MessageUtils;
import com.am.broker.utils.ServletUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;

/**
 * @author jinyongbin
 */
@Component
public class MessagesFilter implements Filter {

    private static String lang = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化过滤器，例如加载配置文件或数据库连接
        System.out.println("Filter initialized.");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        lang = ServletUtils.getCookie((HttpServletRequest) servletRequest, "lang");
        if (Objects.isNull(lang)) {
            lang = Locale.ENGLISH.getLanguage();
        }
        MessageUtils.setLanguage(lang);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
