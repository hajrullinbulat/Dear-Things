package ru.dz.labs.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dz.labs.Constants;
import ru.dz.labs.services.CategoriesService;

import javax.servlet.http.HttpServletRequest;


/**
 *  АОП для наличия категорий товаров на необхадимых страницах
 */
@Aspect
@Component
public class CatalogIncludeAspect {
    @Autowired
    CategoriesService categoriesService;

    @Autowired
    HttpServletRequest request;

    @Pointcut("@annotation(ru.dz.labs.aspects.annotation.CatalogInclude)")
    public void catalogIncludeMethod() {

    }

    @Before("catalogIncludeMethod()")
    public void catalogInclude() {
        request.getSession().setAttribute(Constants.CATEGORIES, categoriesService.getMainCategories());
    }

}
