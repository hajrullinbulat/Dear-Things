package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dz.labs.model.Carts;
import ru.dz.labs.services.CartsService;
import ru.dz.labs.services.UsersService;

import java.util.List;


@Controller
@RequestMapping("/cart")
public class CartController extends BaseController {
    @Autowired
    CartsService cartsService;
    @Autowired
    UsersService usersService;

    @RequestMapping()
    public String renderMyCartPage() {
        List usersCart = cartsService.getUsersCart(usersService.getUsersById(1L));
        request.getSession().setAttribute("cart", usersCart);
        return "pages/cart";
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addInCart(Long goodId) {
//        request.getSession().getAttribute("user");
        cartsService.addToCart(goodId, 1L);
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteFromCart(Long cartId) {
//        request.getSession().getAttribute("user");
        cartsService.deleteFromCart(cartId);
        return "ok";
    }
}
