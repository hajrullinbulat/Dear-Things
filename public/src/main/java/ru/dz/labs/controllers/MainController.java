package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.Constants;
import ru.dz.labs.aspects.annotation.CatalogInclude;
import ru.dz.labs.services.GoodsService;


@Controller
public class MainController extends BaseController {
    @Autowired
    GoodsService goodsService;

    @CatalogInclude
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMyMainPage(Boolean error) {
        //ошибка авторизации
        request.setAttribute(Constants.ERROR, error);
        request.setAttribute(Constants.GOODS, goodsService.getGoodsToMain());
        return "pages/main";
    }
}
