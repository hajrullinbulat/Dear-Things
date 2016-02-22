package ru.dz.labs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ItemController extends BaseController {
    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public String renderMyItemPage() {
        return "main/item";
    }
}
