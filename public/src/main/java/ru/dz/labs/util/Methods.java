package ru.dz.labs.util;

import org.springframework.util.DigestUtils;
import ru.dz.labs.model.Categories;
import ru.dz.labs.model.Goods;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayDeque;

public class Methods {
    /**
     * For breadcrumbs - возврат дерева категории товара
     */
    public static ArrayDeque<Categories> getCategories(Goods good) {
        Categories cat = good.getCategories();

        ArrayDeque<Categories> categories = new ArrayDeque<>();
        while (cat.getId() != 1) {
            categories.addFirst(cat);
            cat = cat.getParent();
        }
        categories.addFirst(cat);

        return categories;
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
        String goods = Methods.getCookiesValue(request, "cart");     //1,5,3,
        System.out.println(goods);
        System.out.println(goodId);
        String answer = goods.replace(goodId + ",", "");

        Cookie cookie = new Cookie("cart", answer);
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

    public static boolean checkNotNullPasswords(String userEditOldPass, String userEditNewPass) {
        return checkOfNull(userEditOldPass) && checkOfNull(userEditNewPass);
    }
}
