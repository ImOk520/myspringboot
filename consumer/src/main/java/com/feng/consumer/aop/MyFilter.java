package com.feng.consumer.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Feng, Ge 2020/12/11 0011 13:51
 */
@Slf4j
@Order(1)
@WebFilter(filterName="myFilter", urlPatterns="/*")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //TODO something
    }

    @Override
    public void destroy() {
        //TODO something
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("【进入过滤器myFilter】");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //取Body数据
        MyRequestWrapper requestWrapper = new MyRequestWrapper(request);
        String body = requestWrapper.getBody();
        //TODO something
        log.info("【滤器获取的body参数：】{}", body);
        filterChain.doFilter(requestWrapper != null ? requestWrapper :request,servletResponse);
    }
}