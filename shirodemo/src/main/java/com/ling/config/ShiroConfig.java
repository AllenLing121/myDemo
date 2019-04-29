package com.ling.config;

import com.ling.shiro.MyAuthRealm;
import com.ling.shiro.MyCredentalsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Lian on 04/29/2019.
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/home");
        shiroFilterFactoryBean.setUnauthorizedUrl("/login");
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/components/**", "anon");
        filterChainDefinitionMap.put("/favicon.ico", "anon");
        
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(MyAuthRealm authRealm,MyCredentalsMatcher matcher){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        authRealm.setCredentialsMatcher(matcher);
        securityManager.setRealm(authRealm);
        return securityManager;
    }
}
