package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.Filter;
import ru.dz.labs.Pagination;
import ru.dz.labs.services.CategoriesService;
import ru.dz.labs.services.GoodsService;

import javax.annotation.PostConstruct;


@Controller
@RequestMapping("/catalog")
public class CatalogController extends BaseController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    CategoriesService categoriesService;

    Filter filter;
    Pagination pagination;

    @PostConstruct
    public void init() {
        filter = new Filter();
    }


    @RequestMapping(value = "/{page}", method = RequestMethod.GET)
    public String renderMyCatalogPage(@PathVariable("page") Integer page) {
//        List<Goods> goodsOnPage = new ArrayList<>();
        //            pagination = new Pagination(goods.size(), page, 3);
//        pagination.setNowPage(page);
//        for (Integer i = pagination.getBeginIndex(); i < pagination.getEndIndex() && i < goods.size(); i++) {
//            goodsOnPage.add(goods.get(i));
//        }
//        request.getSession().setAttribute("goods", goodsOnPage);
        setFilter(
                request.getParameter("category"),
                request.getParameter("price_begin"),
                request.getParameter("price_end"),
                request.getParameter("sort")
        );

        request.getSession().setAttribute("filter", filter);

        request.getSession().setAttribute("goods",
                goodsService.getGoodsAfterFilter(
                        filter.getCategory(),
                        filter.getPriceBegin(),
                        filter.getPriceEnd(),
                        filter.getSort())
        );
        return "pages/catalog";
    }

    private void setFilter(String category, String priceB, String priceE, String sort) {
        if (category != null) {
            try {
                filter.setCategory(categoriesService.getCategoryById(Long.valueOf(category)));
            } catch (NumberFormatException ignored) {
            }
        }
        if (sort != null) {
            filter.setSort(sort);
        }
        if (null != priceB && !priceB.equals("") && null != priceE && !priceE.equals("")) {
            filter.setPrices(priceB, priceE);
        }
    }
}



