package ru.dz.labs.util;

import org.springframework.util.DigestUtils;
import ru.dz.labs.model.Categories;
import ru.dz.labs.model.Goods;
import ru.dz.labs.services.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    public static String passToHash(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }

    public static boolean checkOfNull(String s) {
        return null != s && !s.isEmpty();
    }

    public static String getCookiesValue(HttpServletRequest request, String value) {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals(value)) {
                return c.getValue();
            }
        }
        return null;
    }

    public static void deleteCookie(String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(value, "");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

}
