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
            String cartGoods = Methods.getCookiesValue(request, "cart");
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
            String cookieVal = Methods.getCookiesValue(request, "cart");
            if (Methods.checkOfNull(cookieVal)) {
                if (!checkContains(cookieVal, String.valueOf(goodId)))
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


    @RequestMapping(value = "/deletefromcook", method = RequestMethod.POST)
    public String deleteFromCart(HttpServletResponse response, String index) {
        deleteFromCartCookie(request, response, index);
        return "redirect:/cart";
    }


    private void deleteFromCartCookie(HttpServletRequest request, HttpServletResponse response, String goodId) {
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

    private boolean checkContains(String goods, String good) {
        return goods.contains(good);
    }
}
