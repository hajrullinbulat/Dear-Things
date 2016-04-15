package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.aspects.annotation.CatalogInclude;
import ru.dz.labs.services.GoodsService;


@Controller
public class MainController extends BaseController {
    @Autowired
    GoodsService goodsService;

    @CatalogInclude
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMyMainPage(Boolean error) {
        request.setAttribute("error", error);
        request.setAttribute("goods", goodsService.getGoodsToMain());
        return "pages/main";
    }
}
