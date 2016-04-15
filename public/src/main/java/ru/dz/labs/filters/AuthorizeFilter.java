package ru.dz.labs.filters;

import org.springframework.security.core.context.SecurityContextHolder;
import ru.dz.labs.Constants;
import ru.dz.labs.security.MyUserDetail;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthorizeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (request.getSession().getAttribute(Constants.SESSION_USER) == null) {
            Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (user instanceof MyUserDetail) {
                request.getSession().setAttribute(Constants.SESSION_USER, ((MyUserDetail) user).getUserInfo());
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
