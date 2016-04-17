package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dz.labs.Constants;
import ru.dz.labs.aspects.annotation.AttsInclude;
import ru.dz.labs.aspects.annotation.CatalogInclude;
import ru.dz.labs.model.Users;
import ru.dz.labs.services.CartsService;
import ru.dz.labs.services.GoodsService;
import ru.dz.labs.services.UsersService;
import ru.dz.labs.util.Methods;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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

    @AttsInclude
    @CatalogInclude
    @RequestMapping(method = RequestMethod.GET)
    public String renderMyCartPage() {
        Users user = (Users) request.getSession().getAttribute(Constants.SESSION_USER);
        List cart = null;
        if (null != user) {
            cart = cartsService.getUsersCart(user);
            request.getSession().setAttribute(Constants.CART, cart);
        } else {
            String cartGoods = Methods.getCookiesValue(request, Constants.CART);
            if (Methods.checkOfNull(cartGoods)) {
                cart = goodsService.getGoodsFromCookie(cartGoods);
            }
            request.setAttribute(Constants.CART_FROM_COOKIE, cart);
        }
        return "pages/cart";
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addInCart(Long goodId, HttpServletResponse response) {
        Users user = (Users) request.getSession().getAttribute(Constants.SESSION_USER);
        if (null != user) {     //пользователь авторизован
            if (!cartsService.checkOfExistingItemInCart(user, goodId)) {
                cartsService.addToCart(user, goodId);
            } else {
                return "exist";
            }
        } else {  //пользователь не авторизован
            String cookieVal = Methods.getCookiesValue(request, Constants.CART);
            if (Methods.checkOfNull(cookieVal)) {
                if (!Methods.checkContains(cookieVal, String.valueOf(goodId)))
                    cookieVal = cookieVal + String.valueOf(goodId) + ",";
            } else {
                cookieVal = String.valueOf(goodId) + ",";
            }
            Cookie cookie = new Cookie(Constants.CART, cookieVal);
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
    public String deleteFromCart(HttpServletResponse response, String id) {
        Methods.deleteFromCartCookie(request, response, id);
        return "redirect:/cart";
    }
}
