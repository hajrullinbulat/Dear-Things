package ru.dz.labs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController extends BaseController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMyMainPage() {
        return "pages/main";
    }
}
