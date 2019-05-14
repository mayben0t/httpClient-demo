package com.example.httpclient.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 配置shiro的过滤器
 */
@Order(2)
@WebFilter(filterName = "shiroFilter" , urlPatterns = "/*")
public class ShiroFilter implements Filter {
    @Autowired
    DelegatingFilterProxy delegatingFilterProxy;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        delegatingFilterProxy.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        delegatingFilterProxy.doFilter(servletRequest,servletResponse,filterChain);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        delegatingFilterProxy.destroy();
    }
}
