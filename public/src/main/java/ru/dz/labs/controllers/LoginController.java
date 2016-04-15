package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.labs.model.Users;
import ru.dz.labs.security.MyUserDetail;
import ru.dz.labs.services.CartsService;
import ru.dz.labs.services.UsersService;
import ru.dz.labs.util.Methods;

import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController extends BaseController {
    @Autowired
    UsersService usersService;
    @Autowired
    CartsService cartsService;

    @RequestMapping(value = "/success_log", method = RequestMethod.GET)
    public String success(HttpServletResponse response) {
        MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users myUser = user.getUserInfo();
        request.getSession().setAttribute("user", myUser);

        String cart = Methods.getCookiesValue(request, "cart");
        if (Methods.checkOfNull(cart)) {
            cartsService.toCartFromCook(myUser, cart.split(","));
        }
        Methods.deleteCookie("cart", response);
        request.getSession().setAttribute("cookiecart", null);
        return "redirect:/profile";
    }
}
