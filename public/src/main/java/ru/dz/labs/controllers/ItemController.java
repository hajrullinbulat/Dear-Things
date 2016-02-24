package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.services.GoodsService;


@Controller
public class ItemController extends BaseController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public String renderMyItemPage(@PathVariable("id") Long id) {
        request.getSession().setAttribute("item", goodsService.getGoodById(id));
        return "pages/item";
    }
}
