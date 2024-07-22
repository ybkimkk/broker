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

//    private static String lang = null;
    @Override
    public void init(FilterConfig filterConfig) {
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
