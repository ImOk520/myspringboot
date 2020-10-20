package com.feng.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 过滤规则类
 * Feng, Ge 2020-10-20 15:50
 */
@Slf4j
@Component
public class Filter extends ZuulFilter {

    /**
     * 过滤器类型 pre表示在请求之前进行逻辑操作
     */
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序 当一个请求在同一个阶段存在多个过滤器的时候 过滤器的执行顺序
     */
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否开启过滤
     */
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 要实现的过滤规则在这里完成，比如我们可以做token验证，token=6 时就能进入，不被过滤
     */
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");
        StringBuffer requestURL = request.getRequestURL();
        log.info("【请求路径】：{}", requestURL + "?" + request.getQueryString());
        if (StringUtils.isEmpty(token) || !"6".equals(token)) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody("No access rights!");
            currentContext.setResponseStatusCode(401);
        }
        return null;
    }
}
