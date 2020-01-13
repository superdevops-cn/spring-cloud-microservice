package com.sugelamei.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

public class RouteLogZuulFilter extends ZuulFilter {
    private  static final Logger  LOGGER = LoggerFactory.getLogger(RouteLogZuulFilter.class);
    @Override
    public String filterType() {
        //"route"类型过滤器
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SIMPLE_HOST_ROUTING_FILTER_ORDER-1;
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
