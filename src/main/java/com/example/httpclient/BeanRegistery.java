package com.example.httpclient;


import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.anon;
import static org.apache.shiro.web.filter.mgt.DefaultFilter.authc;
import static org.apache.shiro.web.filter.mgt.DefaultFilter.logout;

@Configuration
public class BeanRegistery {

    @Bean(name="delegatingFilterProxy")
    public org.springframework.web.filter.DelegatingFilterProxy getShiroFilter(){
        DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
        delegatingFilterProxy.setTargetFilterLifecycle(true);
        return delegatingFilterProxy;
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        //未登录时的跳转页面
        shiroFilter.setLoginUrl("");
        //权限不足的跳转页面
        shiroFilter.setUnauthorizedUrl("");
        //
        shiroFilter.setFilterChainDefinitions("
//                <!--匿名访问，/api/login是登陆接口，当然可以随便访问-->
                /api/login = anon
                /api/test? = authc
//                <!--本工程中上传文件的接口，只允许有common角色的用户访问-->
                /api/file = roles[common]
//                <!--用户退出登录的接口，后端不需要实现该接口，logout拦截到/api/logout的url后，就自动清除登录状态回到首页了-->
//                <!--因为在web.xml中设置的url-parttern是/api/*，随意只有api开头的url才会被拦截-->
                /api/logout = logout
//                <!--使用自定义拦截器的接口-->
//                <!--/api/selfFilter = myFilter-->
//                <!--其他所有接口都需要认证，也就是需要之前输入过账号密码登录过-->
//                /** = authc
                ");
    }
}
