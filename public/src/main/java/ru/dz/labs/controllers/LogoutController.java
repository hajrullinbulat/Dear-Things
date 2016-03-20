package ru.dz.labs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LogoutController extends BaseController {
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String login() {
        request.getSession().setAttribute("user", null);
        return "redirect:/catalog/1";
    }


}
