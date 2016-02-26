package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.model.Categories;
import ru.dz.labs.model.Goods;
import ru.dz.labs.services.CategoriesService;
import ru.dz.labs.services.GoodsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


@Controller
public class ItemController extends BaseController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    CategoriesService categoriesService;

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public String renderMyItemPage(@PathVariable("id") Long id) {
        Goods goodById = goodsService.getGoodById(id);
        request.getSession().setAttribute("item", goodById);

        Stack<Categories> categoriesStack = new Stack<>();
        List<Categories> categoriesList = new ArrayList<>();

        Categories categories = goodById.getCategories();
        while (categories.getId() != 1) {
            categoriesStack.push(categories);
            categories = categoriesService.getCategoriesById(categories.getParent_id());
        }
        categoriesStack.push(categories);

        while(!categoriesStack.empty())
            categoriesList.add(categoriesStack.pop());

        request.getSession().setAttribute("category", categoriesList);
        return "pages/item";
    }
}
