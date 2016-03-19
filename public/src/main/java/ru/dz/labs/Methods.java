package ru.dz.labs;

import ru.dz.labs.model.Categories;
import ru.dz.labs.model.Goods;
import ru.dz.labs.services.UsersService;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Methods {
    public static boolean checkEmail(UsersService usersService, String userEmail) {
        return usersService.checkEmail(userEmail);
    }

    public static List getCategories(Goods good) {
        Stack<Categories> categoriesStack = new Stack<>();
        List<Categories> categoriesList = new ArrayList<>();

        Categories categories = good.getCategories();

        while (categories.getId() != 1) {
            categoriesStack.push(categories);
            categories = categories.getParent();
        }
        categoriesStack.push(categories);

        while (!categoriesStack.empty())
            categoriesList.add(categoriesStack.pop());

        return categoriesList;
    }
}
