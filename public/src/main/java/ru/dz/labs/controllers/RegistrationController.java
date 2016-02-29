package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.model.Categories;
import ru.dz.labs.model.Goods;
import ru.dz.labs.services.CategoriesService;
import ru.dz.labs.services.GoodsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


@Controller
public class RegistrationController extends BaseController {
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String renderMyItemPage() {
        return "pages/registration";
    }
}
