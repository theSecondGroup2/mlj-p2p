package com.aaa.p2p.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * className:ShiroConfig
 * discription:
 * author:luRuiHua
 * createTime:2018-11-30 14:36
 * 拦截器作用：如果没登陆或者用户名密码输错，登陆index.html失败，跳转到login.html
 *              如果登陆成功，可以访问index.html
 *              不能直接访问user/student----------student授权
 *                          user/teacher---------teacher授权
 *                          user/index
 *              可以访问user/login
 *                      user/toLogin
 *
 */
@Configuration//配置类
public class ShiroConfig {
    /**
     * 1. 创建ShiroFilterFactoryBean;
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //添加shiro的过滤器
        //shiro的内置过滤器：可以实现权限的相关拦截
        //常用的过滤器：
        //1.anno：无需认证（登陆即可访问）
        //2.authc：必须认证才可以访问
        //3.user：如果使用remanberMe的功能就可以直接访问
        //4.perms：该资源必须得到资源权限才可以访问
        //5.role：该资源必须得到角色权限才可以访问
        Map filterMap = new HashMap();

        //必须登陆才可以访问
        //设置哪些页面必须授权后才可以登陆
        filterMap.put("/emp/toList","authc");//
        //filterMap.put("/poewr/","authc");//
        //filterMap.put("/user/index","authc");//首页

        //被拦截后跳转登陆页面
        shiroFilterFactoryBean.setLoginUrl("/power/userLogin");
        //未授权跳转页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/power/userLogin");




        //将filterMap中的url和相关权限交给shiro框架管理
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }
    /**
     * 2. 创建DefaultWebSecurityManager;
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        //关联realm
        securityManager.setRealm(userRealm);

        return securityManager;
    }
    /**
     * 3. 创建Realm;
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }
    /**
     * 配置shiroDialect，用于thymeleaf和shiro标签配合使用
     */
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
