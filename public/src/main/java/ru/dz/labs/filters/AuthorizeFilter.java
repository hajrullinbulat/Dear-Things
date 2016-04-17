package ru.dz.labs.filters;

import org.springframework.security.core.context.SecurityContextHolder;
import ru.dz.labs.security.MyUserDetail;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthorizeFilter implements Filter {
    boolean firstTime;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        firstTime = true;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (firstTime) {
            Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (user instanceof MyUserDetail) {
                HttpServletRequest request = (HttpServletRequest) servletRequest;
                request.getSession().setAttribute("user", ((MyUserDetail) user).getUserInfo());
            }
            firstTime = false;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
