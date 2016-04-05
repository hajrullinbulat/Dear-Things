package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.Filter;
import ru.dz.labs.services.CategoriesService;
import ru.dz.labs.services.GoodsService;
import ru.dz.labs.util.Methods;

import javax.annotation.PostConstruct;


@Controller
@RequestMapping("/catalog")
public class CatalogController extends BaseController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    CategoriesService categoriesService;

    Filter filter;

    @PostConstruct
    public void init() {
        filter = new Filter();
    }


    @RequestMapping(method = RequestMethod.GET)
    public String renderMyCatalogPage(String category, String price_begin, String price_end, String sort) {
        setFilter(category, price_begin, price_end, sort);

        request.setAttribute("filter", filter);

        request.setAttribute("goods",
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
        if (Methods.checkOfNull(priceB) && Methods.checkOfNull(priceE)) {
            filter.setPrices(priceB, priceE);
        }
    }
}



