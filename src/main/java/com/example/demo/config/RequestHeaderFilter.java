package com.example.demo.config;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.constant.common.HeaderEnum;
import com.google.common.base.Strings;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestHeaderFilter extends OncePerRequestFilter {
    @Autowired
    private SimpleDateFormat sdf;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        RequestContext ctx = new RequestContext();
        RequestContextHolder.set(ctx);
        String clientMessageId = request.getHeader(HeaderEnum.CLIENT_MESSAGE_ID.getLabel());
        if (Strings.isNullOrEmpty(clientMessageId)) {
            clientMessageId = UUID.randomUUID().toString();
        }
        ctx.setClientMessageId(clientMessageId);
        String clientTimeStr = request.getHeader(HeaderEnum.CLIENT_TIME.getLabel());
        if (!Strings.isNullOrEmpty(clientTimeStr)) {
            try {
                Date clientTime = sdf.parse(clientTimeStr);
                ctx.setClientTime(clientTime);
            } catch (Exception e) {
            }
        }
        ctx.setReceivedTime(System.currentTimeMillis());
        filterChain.doFilter(request, response);
    }

}