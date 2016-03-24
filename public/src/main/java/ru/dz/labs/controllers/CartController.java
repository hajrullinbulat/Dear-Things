package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dz.labs.model.Users;
import ru.dz.labs.services.CartsService;
import ru.dz.labs.services.GoodsService;
import ru.dz.labs.services.UsersService;
import ru.dz.labs.util.Methods;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping("/cart")
public class CartController extends BaseController {
    @Autowired
    CartsService cartsService;
    @Autowired
    UsersService usersService;
    @Autowired
    GoodsService goodsService;

    @RequestMapping(method = RequestMethod.GET)
    public String renderMyCartPage() {
        Users user = (Users) request.getSession().getAttribute("user");
        List cart = null;
        if (null != user) {
            cart = cartsService.getUsersCart(user);
            request.getSession().setAttribute("cart", cart);
        } else {
            String cartGoods = getCookiesValue(request, "cart");
            if (Methods.checkOfNull(cartGoods)) {
                cart = goodsService.getGoodsFromCookie(cartGoods);
            }
            request.getSession().setAttribute("cookiecart", cart);
        }
        return "pages/cart";
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addInCart(Long goodId, HttpServletResponse response) {
        Users user = (Users) request.getSession().getAttribute("user");
        if (null != user) {     //пользователь авторизован
            if (!cartsService.checkOfExistingItemInCart(user, goodId)) {
                cartsService.addToCart(user, goodId);
            } else {
                return "exist";
            }
        } else {  //пользователь не авторизован
            String cookieVal = getCookiesValue(request, "cart");
            if (Methods.checkOfNull(cookieVal)) {
                cookieVal = cookieVal + String.valueOf(goodId) + ",";
            } else {
                cookieVal = String.valueOf(goodId) + ",";
            }
            Cookie cookie = new Cookie("cart", cookieVal);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteFromCart(Long cartId) {
        cartsService.deleteFromCart(cartId);
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public String changeCountOfItem(Long cartId, Integer count) {
        if (count > 0) {
            cartsService.updateCountOfCart(cartId, count);
            return "ok";
        } else {
            cartsService.deleteFromCart(cartId);
            return "deleted";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/change_forward", method = RequestMethod.POST)
    public String changeCountOfItemForward(Long cartId, Integer count) {
        cartsService.updateCountOfCart(cartId, count);
        return "ok";
    }

    @RequestMapping(value = "/deletefromcook", method = RequestMethod.POST)
    public String deleteFromCart(HttpServletResponse response) {
        deleteFromCartCookie(request, response, request.getParameter("index"));
        return "redirect:/cart";
    }


    private String getCookiesValue(HttpServletRequest request, String value) {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals(value)) {
                return c.getValue();
            }
        }
        return null;
    }

    private void deleteFromCartCookie(HttpServletRequest request, HttpServletResponse response, String goodId) {
        String goods = getCookiesValue(request, "cart");
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
}
