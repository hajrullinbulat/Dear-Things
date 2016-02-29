package ru.dz.labs.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.dz.labs.Pagination;
import ru.dz.labs.model.Goods;
import ru.dz.labs.services.GoodsService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class CatalogFilter implements Filter {
    @Autowired
    GoodsService goodsService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        List<Goods> allGoods = goodsService.getAllGoods();
        request.getSession().setAttribute("goods", allGoods);
        request.getSession().setAttribute("pagination", new Pagination(allGoods.size(), 1, 3));
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
