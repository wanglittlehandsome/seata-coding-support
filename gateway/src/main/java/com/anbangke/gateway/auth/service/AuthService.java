package com.anbangke.gateway.auth.service;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * @author wangerxiao
 * @date 2020/5/24 19:33
 * @email 784665813@qq.com
 */
@Service
@Slf4j
public class AuthService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 根据用户的唯一标识获取该用户的权限列表
     */
    public Set<String> getUserPermissions(String account) {
        if ("aUser".equals(account)) {
            return Sets.newHashSet("order", "storage");
        }
        return Collections.emptySet();
    }

    /**
     * 根据用户的唯一标识获取accessToken的加密密钥
     */
    public String getUserSecret(String account) {
        return "token-secret";
    }

    /**
     * 获取所有的接口url与用户权限的映射关系,格式仿造了shiro的权限配置格式
     */
    public Map<String, String> getAllUrlPermissionsMap() {
        Map<String, String> urlPermissionsMap = Maps.newHashMap();
        urlPermissionsMap.put("/order-service/api/order/orders", "authc");
        urlPermissionsMap.put("/order-service/api/order/create-order", "perms[order]");
        urlPermissionsMap.put("/storage-service/api/storage/**", "perms[storage]");
        return urlPermissionsMap;
    }

    /**
     * 根据一个确定url获取该url对应的权限设置
     * 利用AntPathMatcher进行模式匹配
     */
    private String getUrlPermission(String url) {
        if (Strings.isNullOrEmpty(url)) {
            return null;
        }
        Map<String, String> urlPermissionsMap = getAllUrlPermissionsMap();
        Set<String> urlPatterns = urlPermissionsMap.keySet();
        for (String pattern : urlPatterns) {
            boolean match = false;
            if (antPathMatcher.isPattern(pattern)) {
                match = antPathMatcher.match(pattern, url);
            } else {
                match = url.equals(pattern);
            }
            if (match) {
                return urlPermissionsMap.get(pattern);
            }
        }
        return null;
    }

    /**
     * 后续加入通过token获取用户信息
     * @param token
     * @return
     */
    public String getAccountByToken(String token) {
        return "";
    }

    public boolean verifyToken(String url, String token) {
        if (Strings.isNullOrEmpty(token)) {
            return false;
        }
        String urlPermission = getUrlPermission(url);
        if ("anno".equals(urlPermission)) {
            return true;
        } else {
            if (Strings.isNullOrEmpty(urlPermission) ||
                    "authc".equals(urlPermission)) {
                return true;
            }
        }
        return false;
    }

}
