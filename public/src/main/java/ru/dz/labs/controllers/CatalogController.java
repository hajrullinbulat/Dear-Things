package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dz.labs.Constants;
import ru.dz.labs.pojo.Filter;
import ru.dz.labs.aspects.annotation.CatalogInclude;
import ru.dz.labs.services.CategoriesService;
import ru.dz.labs.services.GoodsService;
import ru.dz.labs.util.Methods;

import javax.annotation.PostConstruct;
import java.util.List;


@Controller
@RequestMapping("/catalog")
public class CatalogController extends BaseController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    CategoriesService categoriesService;

    List goodsAfterFilter;
    Filter filter;
    Integer goods_limit;
    int size;

    @PostConstruct
    public void init() {
        filter = new Filter();
        goods_limit = Constants.GOODS_PER_SHOW;
    }


    @CatalogInclude
    @RequestMapping(method = RequestMethod.GET)
    public String renderMyCatalogPage(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                      String category, String price_begin, String price_end, String sort, Long limit) {
        setFilter(category, price_begin, price_end, sort);

        request.setAttribute(Constants.FILTER, filter);
        goodsAfterFilter = goodsService.getGoodsAfterFilter(
                filter.getCategory(),
                filter.getPriceBegin(),
                filter.getPriceEnd(),
                filter.getSort());

        size = goodsAfterFilter.size();

        request.setAttribute(Constants.GOODS, size > goods_limit ? goodsAfterFilter.subList(0, goods_limit) : goodsAfterFilter.subList(0, size));

        request.setAttribute(Constants.GOODS_COUNT, size);
        request.setAttribute(Constants.GOODS_LIMIT, limit == null ? goods_limit : limit);
        request.setAttribute(Constants.PAGE, page);

        return "pages/catalog";
    }

    @RequestMapping(value = "/more", method = RequestMethod.POST)
    public String showMoreGoods(Integer limit, Integer page) {
        if (size > page * limit) {
            request.setAttribute(Constants.GOODS, page * goods_limit + goods_limit < size
                    ? goodsAfterFilter.subList(page * goods_limit, page * goods_limit + goods_limit)
                    : goodsAfterFilter.subList(page * goods_limit, size));
        } else {
            request.setAttribute(Constants.GOODS, goodsAfterFilter);
        }
        return "parts/ajaxItems";
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



