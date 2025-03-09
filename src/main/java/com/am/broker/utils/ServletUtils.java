package com.am.broker.utils;

import lombok.Getter;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 客户端工具类
 *
 * @author ruoyi
 */
public class ServletUtils {
    /**
     * 定义移动端请求的所有可能类型
     */
    private final static String[] agent = {"Android", "iPhone", "iPod", "iPad", "Windows Phone", "MQQBrowser"};

    @Getter
    private static final List<String> filterList = new ArrayList<>();

    static {
        filterList.add(".css");
        filterList.add(".jpeg");
        filterList.add(".jpg");
        filterList.add(".js");
        filterList.add(".png");
        filterList.add(".woff2");
        filterList.add(".ico");
        filterList.add(".svg");
        filterList.add(".gif");
    }


    public static boolean checkStatic(HttpServletRequest httpRequest) {
        return ServletUtils.getFilterList().stream().anyMatch(httpRequest.getRequestURI()::endsWith);
    }

    /**
     * 获取request
     */
    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }

    /**
     * 获取session
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static ServletRequestAttributes getRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }

    public static String getCookie(HttpServletRequest request, String name) {
        String value = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    try {
                        value = URLDecoder.decode(cookie.getValue(), "utf-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return value;
    }

    public static String getClientIp(HttpServletRequest request) {

        String ip = request.getHeader("X-Forwarded-For");
        if (ip != null && !ip.isEmpty() && !"unknown".equalsIgnoreCase(ip)) {
            // 可能有多个IP，用逗号分隔，取第一个IP
            return ip.split(",")[0].trim();
        }

        ip = request.getHeader("X-Real-IP");
        if (ip != null && !ip.isEmpty() && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }

        return request.getRemoteAddr(); // 备用方案
    }

}
