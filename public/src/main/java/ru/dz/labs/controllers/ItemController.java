package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.util.Methods;
import ru.dz.labs.model.Goods;
import ru.dz.labs.services.CategoriesService;
import ru.dz.labs.services.GoodsService;


@Controller
public class ItemController extends BaseController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    CategoriesService categoriesService;

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public String renderMyItemPage(@PathVariable("id") Long id) {
        Goods goodById = goodsService.getGoodById(id);
        //дерево категорий
        request.getSession().setAttribute("category", Methods.getCategories(goodById));
        //сам предмет
        request.getSession().setAttribute("item", goodById);
        //предеметы в той же категории либо выше
        request.getSession().setAttribute("like", goodsService.getLikeGoods(goodById));

        return "pages/item";
    }
}
