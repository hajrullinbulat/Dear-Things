package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.Constants;
import ru.dz.labs.aspects.annotation.AttsInclude;
import ru.dz.labs.aspects.annotation.CatalogInclude;
import ru.dz.labs.model.Users;
import ru.dz.labs.services.CartsService;
import ru.dz.labs.services.UsersService;

@Controller
public class ProfileController extends BaseController {
    @Autowired
    UsersService usersService;

    @Autowired
    CartsService cartsService;

    @AttsInclude
    @CatalogInclude
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String renderEditPage() {
        Users user = (Users) request.getSession().getAttribute(Constants.SESSION_USER);
        request.setAttribute(Constants.ORDERS, usersService.getUsersById(user.getId()).getOrders());
        return "pages/profile";
    }
}
