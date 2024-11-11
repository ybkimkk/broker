package com.am.broker.filter;

import com.am.broker.utils.ServletUtils;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CountryResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.InetAddress;

@Slf4j
@Component
@WebFilter("/*")
@Order(1)
public class IpFilter implements Filter {

    private DatabaseReader dbReader;
    private String osName;

    @SneakyThrows
    @Override
    public void init(FilterConfig filterConfig) {
        Filter.super.init(filterConfig);
        osName = System.getProperty("os.name").toLowerCase();
        // 使用 ClassPathResource 读取位于 resources 目录下的文件
        Resource resource;
        if (osName.startsWith("windows")) {
            resource = new ClassPathResource("GeoLite2\\GeoLite2-Country.mmdb");
        } else {
            resource = new ClassPathResource("GeoLite2/GeoLite2-Country.mmdb");
        }
        InputStream inputStream = resource.getInputStream();
        dbReader = new DatabaseReader.Builder(inputStream).build();
    }

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        if (!osName.startsWith("windows")) {
            String requestURI = httpRequest.getRequestURI();
            if (!requestURI.equals("/denied")) {
                try {
                    String ipAddress = ServletUtils.getClientIp(httpRequest);
                    InetAddress ipAddressInet = InetAddress.getByName(ipAddress);
                    CountryResponse countryResponse = dbReader.country(ipAddressInet);
                    String countryCode = countryResponse.getCountry().getIsoCode();
                    // 如果是新西兰或澳大利亚的IP，拒绝访问
                    if ("NZ".equals(countryCode) || "AU".equals(countryCode)) {
                        httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
                        httpResponse.sendRedirect("/denied");
                    }
                } catch (Exception e) {
                    filterChain.doFilter(servletRequest, httpResponse);
                }
            }
        }

        filterChain.doFilter(servletRequest, httpResponse);
    }

}
