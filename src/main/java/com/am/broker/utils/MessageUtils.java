package com.am.broker.utils;

import cn.hutool.core.util.StrUtil;
import com.am.broker.spring.SpringUtils;
import org.springframework.context.MessageSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 获取i18n资源文件
 *
 * @author ruoyi
 */

public class MessageUtils {

    private static final MessageSource MESSAGE_SOURCE = SpringUtils.getBean(MessageSource.class);

    private static final ThreadLocal<Locale> CURRENT_LOCALE = new ThreadLocal<>();


    /**
     * 根据消息键和参数 获取消息 委托给spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return 获取国际化翻译值
     */

    public static String message(String code, Object... args) {
        Locale locale = getCurrentLocale();
        return MESSAGE_SOURCE.getMessage(code, args, locale);
    }

    public static Locale getCurrentLocale() {
        Locale locale = CURRENT_LOCALE.get();
        if (locale == null) {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            String lang = ServletUtils.getCookie(request, "lang");
            locale = new Locale(StrUtil.isNotBlank(lang) ? lang : "en");
            CURRENT_LOCALE.set(locale);
        }
        return CURRENT_LOCALE.get();
    }

    // 在需要更新语言的地方调用此方法
    public static void updateLanguage(String lang) {
        Locale locale = new Locale(lang);
        CURRENT_LOCALE.set(locale);
    }

    public static Map<String, String> batchMessage(Collection<String> codes, Object... args) {
        Locale locale = getCurrentLocale();
        return codes.stream().collect(Collectors.toMap(code -> code, code -> MESSAGE_SOURCE.getMessage(code, args, locale)));
    }

    public static Map<String, String> searchMessages(String searchKey, Object... args) {
        Locale locale = getCurrentLocale();
        Properties properties = getAllPropertiesForLocale(locale);
        return properties.entrySet().stream()
                .filter(entry -> entry.getKey().toString().contains(searchKey))
                .collect(Collectors.toMap(entry -> entry.getKey().toString(), entry -> MESSAGE_SOURCE.getMessage(entry.getKey().toString(), args, locale)));
    }

    private static Properties getAllPropertiesForLocale(Locale locale) {
        // 需要根据实际情况加载属性文件内容，这里是一个简化的示例
        Properties properties = new Properties();
        try {
            String baseName = "static/i18n/messages"; // 基础名称
            ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale);
            bundle.keySet().forEach(key -> properties.put(key, bundle.getString(key)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

}
