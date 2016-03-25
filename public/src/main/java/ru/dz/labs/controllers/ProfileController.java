package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.model.Users;
import ru.dz.labs.services.CartsService;
import ru.dz.labs.services.UsersService;

@Controller
public class ProfileController extends BaseController {
    @Autowired
    UsersService usersService;

    @Autowired
    CartsService cartsService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String renderEditPage() {
//        Users user = (Users) request.getSession().getAttribute("user");
//        user = usersService.getUsersById(user.getId());
//        request.getSession().setAttribute("user", usersService.getUsersById(user.getId()));   //нужен EAGER чтоб не пришлось так делать
//        System.out.println("**************************");
//        System.out.println(user.getTelephones());
//        System.out.println(user.getAddresses());
        return "pages/profile";
    }
}
