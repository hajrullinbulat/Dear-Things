package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dz.labs.Methods;
import ru.dz.labs.services.UsersService;

@Controller
public class RegistrationController extends BaseController {
    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String renderMyItemPage() {
        return "pages/registration";
    }

    @ResponseBody
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String checkValidation(String userName, String userEmail, String userPass) {
        if (Methods.checkEmail(usersService, userEmail)) {
            usersService.addUsers(userName, userEmail, userPass);
            request.getSession().setAttribute("user", usersService.checkLogging(userEmail, userPass));
            return "ok";
        } else
            return "failed";
    }
}
