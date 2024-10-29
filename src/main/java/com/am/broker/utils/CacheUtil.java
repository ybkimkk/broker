package com.am.broker.utils;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.convert.Convert;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

@Component
public class CacheUtil {
    private static Cache<String, Object> cache;


    @PostConstruct
    public void init() {
        cache = Caffeine.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(Duration.ofMinutes(15)).build();
    }


    //精确清空缓存
    public static void clear(String cacheKey) {
        cache.invalidate(cacheKey);
    }

    //模糊删除缓存
    public static void clearLikeName(String cacheKey) {
        //TODO 当缓存变量值过多 可以考虑使用并行删除 并等待 ---------金永彬
        cache.asMap().forEach((key, val) -> {
            if (key.contains(cacheKey)) {
                clear(key);
            }
        });
    }

    //获取缓存对象
    public static <T> T getCache(String cacheKey, Class<T> clazz) {
        Object o = cache.getIfPresent(cacheKey);
        if (Objects.nonNull(o)) {
            return Convert.convert(clazz, o);
        }
        return null;
    }

    public static Object getCache(String cacheKey) {
        return cache.getIfPresent(cacheKey);
    }


    //获取缓存列表
    public static <T> List<T> getCacheList(String cacheKey, Class<T> clazz) {
        Object o = cache.getIfPresent(cacheKey);
        if (Objects.nonNull(o)) {
            return Convert.toList(clazz, o);
        }
        return ListUtil.empty();
    }

    //添加缓存
    public static Boolean addCache(String cacheKey, Object object) {
        try {
            cache.put(cacheKey, object);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

