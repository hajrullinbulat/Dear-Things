package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.Pagination;
import ru.dz.labs.services.CategoriesService;
import ru.dz.labs.services.GoodsService;

import java.util.List;


@Controller
@RequestMapping("/catalog")
public class CatalogController extends BaseController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    CategoriesService categoriesService;

    Pagination pagination;

    @RequestMapping(value = "/{page}", method = RequestMethod.GET)
    public String renderMyCatalogPage(@PathVariable("page") Integer page) {
//        List<Goods> goodsOnPage = new ArrayList<>();
        //            pagination = new Pagination(goods.size(), page, 3);
//        pagination.setNowPage(page);
//        for (Integer i = pagination.getBeginIndex(); i < pagination.getEndIndex() && i < goods.size(); i++) {
//            goodsOnPage.add(goods.get(i));
//        }
//        request.getSession().setAttribute("goods", goodsOnPage);

        String category = request.getParameter("category");
        String priceBegin = request.getParameter("price_begin");
        String priceEnd = request.getParameter("price_end");
        String sort = request.getParameter("sort");

        List goodsAfterFilter = goodsService.getGoodsAfterFilter(category, priceBegin, priceEnd, sort);

        setAttributes(category, priceBegin, priceEnd, sort);

        this.request.getSession().setAttribute("goods", goodsAfterFilter);

        return "pages/catalog";
    }

    private void setAttributes(String category, String priceB, String priceE, String sort) {
        if (category != null) {
            request.getSession().setAttribute("cat", categoriesService.getCategoryById(Long.valueOf(category)));
        } else {
            request.getSession().setAttribute("cat", null);
        }
        if (sort != null) {
            if (sort.equals("min")) {
                request.getSession().setAttribute("order", "Минимальной цены");
            } else if (sort.equals("max")) {
                request.getSession().setAttribute("order", "Максимальной цены");
            }
        }
        if (priceB != null && priceE != null) {
            request.getSession().setAttribute("price", priceB + " - " + priceE + " \u20BD");
        } else {
            if (priceB != null) {
                request.getSession().setAttribute("price", priceB + " - ? \u20BD");
            }
            if (priceE != null) {
                request.getSession().setAttribute("price", "? - " + priceE + " \u20BD");
            }
        }
    }
}



