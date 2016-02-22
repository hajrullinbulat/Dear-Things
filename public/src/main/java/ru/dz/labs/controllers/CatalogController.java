package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.services.GoodsService;


@Controller
public class CatalogController extends BaseController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String renderMyCatalogPage() {
        request.getSession().setAttribute("goods", goodsService.getAllGoods());
        return "main/catalog";
    }
}
