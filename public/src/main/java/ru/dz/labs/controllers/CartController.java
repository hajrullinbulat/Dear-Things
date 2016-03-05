package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dz.labs.services.CartsService;


@Controller
@RequestMapping("/cart")
public class CartController extends BaseController {
    @Autowired
    CartsService cartsService;

    @RequestMapping()
    public String renderMyCartPage() {
        return "pages/cart";
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addInCart(Long goodId) {
//        request.getSession().getAttribute("user");
        cartsService.addToCart(goodId, 1L);
        return "ok";
    }

}
