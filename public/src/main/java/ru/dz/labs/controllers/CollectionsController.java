package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.aspects.annotation.CatalogInclude;
import ru.dz.labs.services.CategoriesService;


@Controller
public class CollectionsController extends BaseController {

    @Autowired
    CategoriesService categoriesService;

    @CatalogInclude
    @RequestMapping(value = "/collections", method = RequestMethod.GET)
    public String renderMyCartPage() {
        request.getSession().setAttribute("collections", categoriesService.getAllCategories());
        return "pages/collections";
    }


}
