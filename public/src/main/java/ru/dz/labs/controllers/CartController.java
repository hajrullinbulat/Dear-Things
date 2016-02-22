package ru.dz.labs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CartController extends BaseController {

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String renderMyCartPage() {
        return "main/cart";
    }


}
