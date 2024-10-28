package com.am.broker.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class UrlLoggingInterceptor implements HandlerInterceptor {

    private static final List<String> filterList = new ArrayList<>();

    @PostConstruct
    public void init() {
        filterList.add(".css");
        filterList.add(".js");
        filterList.add(".png");
        filterList.add(".woff2");
        filterList.add(".ico");
        filterList.add(".svg");
        filterList.add(".gif");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        boolean validation = filterList.stream().anyMatch(requestURI::endsWith);
        if (!validation) {
            log.info("interview url is : {}?{}", requestURI, request.getQueryString());
        }
        return true; // 继续执行
    }
}
