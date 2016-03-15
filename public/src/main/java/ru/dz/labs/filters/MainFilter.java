package ru.dz.labs.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.dz.labs.services.CategoriesService;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

@Controller
public class MainFilter implements Filter{
    @Autowired
    CategoriesService categoriesService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        boolean firstTime;
//        List categories =
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
