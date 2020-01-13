package com.sugelamei.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

public class PreLogZuulFilter extends ZuulFilter {

    private static  final Logger LOGGER = LoggerFactory.getLogger(PreLogZuulFilter.class);
    @Override
    public String filterType() {
        //"pre"类型过滤器
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //org.springframework.cloud.netflix.zuul.filters.pre.PreDecorationFilter执行之前执行
        return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        LOGGER.info("request.getMethod()=={},request.getRequestURI()=={}",request.getMethod(),request.getRequestURI());
        return null;
    }
}
