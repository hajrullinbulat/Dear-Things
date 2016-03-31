package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.services.UsersService;


@Controller
public class LoginController extends BaseController {
    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Boolean error) {
        request.setAttribute("error", error);
        return "redirect:/catalog/1";
    }


}
