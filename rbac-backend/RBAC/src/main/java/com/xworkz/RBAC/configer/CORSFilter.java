package com.xworkz.RBAC.configer;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.io.IOException;

//import static jdk.internal.org.jline.utils.Log.debug;

public class CORSFilter implements Filter {
    private static final String ONE_HOUR = "3600";
    private Logger log;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", ONE_HOUR);
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,Origin,Content-Type, Accept, x-device-user-agent, Content-Type");

        if (req instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) req;
            if (httpServletRequest.getHeader(HttpHeaders.ORIGIN) != null
                    && httpServletRequest.getMethod().equals(HttpMethod.OPTIONS.name())
                    && httpServletRequest.getHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD) != null) {
                log.debug("Received an OPTIONS pre-flight request.");
                return;
            }
        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy(){
}
}
