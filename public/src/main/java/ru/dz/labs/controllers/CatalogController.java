package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.Pagination;
import ru.dz.labs.model.Goods;
import ru.dz.labs.services.GoodsService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CatalogController extends BaseController {
    @Autowired
    GoodsService goodsService;
    Pagination pagination;
//
//    @PostConstruct
//    public void init() {
//        pagination = new Pagination(goodsService.getAllGoods().size(), 1, 3);
//    }


    @RequestMapping(value = "/catalog/{page}", method = RequestMethod.GET)
    public String renderMyCatalogPage(@PathVariable("page") Integer page) {
        // TODO: 27.02.2016 В ФИЛЬТР ВСЕ ЭТА НАДА ЗАПИХАТЬ
        List<Goods> goodsOnPage = new ArrayList<>();
        List<Goods> goods = (List<Goods>) request.getSession().getAttribute("goods");



//        List<Goods> goods = goodsService.getAllGoods();
//        request.getSession().setAttribute("goods", goods);

        pagination = (Pagination) request.getSession().getAttribute("pagination");

        for (Integer i = pagination.getBeginIndex(); i < pagination.getEndIndex(); i++) {
            goodsOnPage.add(goods.get(i));
        }

        request.getSession().setAttribute("goods_page", goodsOnPage);

        return "pages/catalog";
    }


}
