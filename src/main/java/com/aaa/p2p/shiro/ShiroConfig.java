package com.aaa.p2p.shiro;

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
 * 拦截器作用：
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
        filterMap.put("/power/wel","authc");//欢迎页面
        filterMap.put("/tree/goTreeList","authc");//菜单树页面
        filterMap.put("/emp/toList","authc");//员工列表页面
        filterMap.put("/dept/toDept","authc");//部门列表页面
        filterMap.put("/emp/updatePassWord","authc");//更改密码页面
        filterMap.put("/bid/toCheckBid","authc");//标初审页面

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

}
