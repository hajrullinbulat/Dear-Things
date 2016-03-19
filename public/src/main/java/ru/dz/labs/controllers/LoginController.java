package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dz.labs.model.Users;
import ru.dz.labs.services.UsersService;


@Controller
public class LoginController extends BaseController {
    @Autowired
    UsersService usersService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String userEmail, String userPass) {
        Users user = usersService.checkLogging(userEmail, userPass);
        if (null != user) {
            request.getSession().setAttribute("user", user);
            return "ok";
        } else
            return "failed";
    }


}
