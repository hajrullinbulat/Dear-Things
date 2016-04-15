package ru.dz.labs.util;

import org.springframework.util.DigestUtils;
import ru.dz.labs.model.Categories;
import ru.dz.labs.model.Goods;
import ru.dz.labs.services.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Methods {
    public static boolean checkEmail(UsersService usersService, String userEmail) {
        return usersService.checkEmail(userEmail);
    }

    /**
     * For breadcrumbs - возврат дерева категории товара
     */
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

    public static boolean checkContains(String goods, String good) {
        return goods.contains(good);
    }

    public static void deleteFromCartCookie(HttpServletRequest request, HttpServletResponse response, String goodId) {
        String goods = Methods.getCookiesValue(request, "cart");
        String[] goodsStringArray = goods.split(",");
        List<String> goodsList = new ArrayList<>();
        Collections.addAll(goodsList, goodsStringArray);
        for (int i = 0; i < goodsStringArray.length; i++)
            if (i == Integer.valueOf(goodId) - 1)
                goodsList.remove(i);
        String ans = "";
        for (String s : goodsList)
            ans = ans + s + ",";
        Cookie cookie = new Cookie("cart", ans);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24 * 365);
        response.addCookie(cookie);
    }

    public static String keyGen() {
        String letters = "abcdefghijklmnopqrstuvwxyz0123456789";
        char[] keyGen = new char[letters.length()];
        for (int i = 0; i < letters.length(); i++) {
            keyGen[i] = letters.charAt((int) (Math.random() * letters.length()));
        }

        return String.valueOf(keyGen);
    }
}
