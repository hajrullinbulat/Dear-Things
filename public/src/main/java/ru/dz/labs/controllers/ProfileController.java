package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.model.Users;
import ru.dz.labs.security.MyUserDetail;
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
        MyUserDetail user  = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        request.getSession().setAttribute("user", user.getUserInfo());
        return "pages/profile";
    }
}
