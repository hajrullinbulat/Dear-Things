package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dz.labs.Mail;
import ru.dz.labs.aspects.annotation.CatalogInclude;
import ru.dz.labs.model.Users;
import ru.dz.labs.services.UsersService;
import ru.dz.labs.util.Methods;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;

@Controller
@RequestMapping("/signup")
public class RegistrationController extends BaseController {
    @Autowired
    UsersService usersService;
    Mail mail;

    @PostConstruct
    public void init() {
        mail = new Mail();
    }

    @CatalogInclude
    @RequestMapping(method = RequestMethod.GET)
    public String renderMyItemPage() {
        return "pages/registration";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public String checkValidation(String userName, String userEmail, String userPass) throws MessagingException {
        if (Methods.checkEmail(usersService, userEmail)) {
            usersService.addUsers(userName, userEmail, userPass);
            Users user = usersService.checkLogging(userEmail, userPass);
            request.getSession().setAttribute("user", user);
            mail.sendMessage("Hello, " + userName + "!",
                    "Перейдите по ссылке для активации аккаунта: http://localhost:8080/signup/key?key=" + user.getKey(),
                    userEmail);
            return "ok";
        } else
            return "failed";
    }

    @RequestMapping(value = "/key", method = RequestMethod.GET)
    public String activateAccount(String key) {
        usersService.activateAccount(key);
        return "redirect:/";
    }
}
