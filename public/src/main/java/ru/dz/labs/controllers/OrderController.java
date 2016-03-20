package ru.dz.labs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class OrderController extends BaseController {
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String renderMyOrderPage() {
        return "pages/order";
    }
}
