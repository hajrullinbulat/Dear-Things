package ru.dz.labs.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dz.labs.Constants;
import ru.dz.labs.model.Users;
import ru.dz.labs.pojo.SumAndCount;
import ru.dz.labs.services.CartsService;
import ru.dz.labs.services.CategoriesService;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AttsIncludeAspect {
    @Autowired
    CategoriesService categoriesService;

    @Autowired
    CartsService cartsService;

    @Autowired
    HttpServletRequest request;

    @Pointcut("@annotation(ru.dz.labs.aspects.annotation.AttsInclude)")
    public void attsIncludeMethod() {

    }

    @Before("attsIncludeMethod()")
    public void attsInclude() {
        if (request.isUserInRole("ROLE_USER")) {
            SumAndCount sumAndCountOfCartByUserId = cartsService.getSumAndCountOfCartByUserId((Users) request.getSession().getAttribute(Constants.SESSION_USER));
            request.getSession().setAttribute(Constants.SUM_CART, sumAndCountOfCartByUserId.getSum());
            request.getSession().setAttribute(Constants.COUNT_CART, sumAndCountOfCartByUserId.getCount());
        }
    }

}
