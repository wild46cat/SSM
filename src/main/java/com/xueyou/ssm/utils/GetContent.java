package com.xueyou.ssm.utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wuxueyou on 16/10/2.
 */
@WebFilter(filterName = "GetContent")
public class GetContent implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        SysContent.setRequest((HttpServletRequest)req);
        SysContent.setResponse((HttpServletResponse)resp);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
