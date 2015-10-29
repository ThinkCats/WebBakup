package com.thinkweb.security;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Objects;

/**
 * Created by wang on 15-10-28.
 */
public class CustomerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        Boolean flag = (Boolean) session.getAttribute("auth");
        Object securityContext = session.getAttribute("SPRING_SECURITY_CONTEXT");
        System.out.println("=============== Has element ================="+flag);
        if (flag == null || securityContext == null){
            //此时用户未登录，设置一个auth属性,提供给前端模板识别
            System.out.println("=============== No Auth ====================");
            session.setAttribute("auth",false);
        }else {
            session.setAttribute("auth",true);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
