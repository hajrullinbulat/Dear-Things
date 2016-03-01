package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.Pagination;
import ru.dz.labs.model.Goods;
import ru.dz.labs.services.GoodsService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Controller
public class CatalogController extends BaseController {
    @Autowired
    GoodsService goodsService;

    Pagination pagination;
    List<Goods> goods;
    boolean firstTime;

    @PostConstruct
    public void init() {
        goods = goodsService.getAllGoods();
        firstTime = true;
    }


    @RequestMapping(value = "/catalog/{page}", method = RequestMethod.GET)
    public String renderMyCatalogPage(@PathVariable("page") Integer page) {
        List<Goods> goodsOnPage = new ArrayList<>();
        if (firstTime) {
//            request.getSession().setAttribute("goods", goods);
            pagination = new Pagination(goods.size(), page, 3);
            firstTime = false;
        }

        pagination.setNowPage(page);
        for (Integer i = pagination.getBeginIndex(); i < pagination.getEndIndex() && i < goods.size(); i++) {
            goodsOnPage.add(goods.get(i));
        }

        request.getSession().setAttribute("goods", goodsOnPage);

        return "pages/catalog";
    }


}
