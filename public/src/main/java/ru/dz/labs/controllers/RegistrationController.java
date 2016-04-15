package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dz.labs.Constants;
import ru.dz.labs.Mail;
import ru.dz.labs.aspects.annotation.CatalogInclude;
import ru.dz.labs.model.Users;
import ru.dz.labs.services.UsersService;
import ru.dz.labs.util.Methods;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;

@Controller
public class RegistrationController extends BaseController {
    @Autowired
    UsersService usersService;
    Mail mail;

    @PostConstruct
    public void init() {
        mail = new Mail();
    }

    @CatalogInclude
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String renderMyItemPage() {
        return "pages/registration";
    }

    @ResponseBody
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String checkValidation(String userName, String userEmail, String userPass) throws MessagingException {
        if (usersService.checkEmail(userEmail)) {
            usersService.addUsers(userName, userEmail, userPass);
            Users user = usersService.checkLogging(userEmail, userPass);
            request.getSession().setAttribute(Constants.SESSION_USER, user);
            mail.sendMessage("Здравствуйте, " + userName + "!",
                    "Перейдите по <a href=http://localhost:8080/signup/key?key=" + user.getKey() + "> ссылке</a>  для активации аккаунта: ",
                    userEmail);
            return "ok";
        } else
            return "failed";
    }

    @RequestMapping(value = "/signup/key", method = RequestMethod.GET)
    public String activateAccount(String key) {
        usersService.activateAccount(key);
        return "redirect:/";
    }

    @RequestMapping(value = "/forgot", method = RequestMethod.GET)
    public String renderForgotPasswordPage() {
        return "pages/forgot";
    }

    @ResponseBody
    @RequestMapping(value = "/forgot", method = RequestMethod.POST)
    public String forgotPassword(String email) throws MessagingException {
        if (!usersService.checkEmail(email)) {
            Users userByEmail = usersService.getUserByEmail(email);
            String newPass = Methods.keyGen();
            usersService.updatePasswordOfUserById(userByEmail.getId(), newPass);
            mail.sendMessage("Восстановление пароля", "Здравствуйте, " + userByEmail.getName() + "! <br> А вот и Ваш новенький пароль : " + newPass + "<br> Поменять его можете в личном кабинете.", email);
            return "ok";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/activation", method = RequestMethod.GET)
    public String renderActivationPage() {
        return "pages/activation";
    }

    @ResponseBody
    @RequestMapping(value = "/activation", method = RequestMethod.POST)
    public String activationAgain(String email, String pass) throws MessagingException {
        Users user = usersService.checkLogging(email, pass);
        if (user != null) {
            mail.sendMessage("Здравствуйте, " + user.getName() + "!",
                    "Перейдите по <a href=http://localhost:8080/signup/key?key=" + user.getKey() + "> ссылке</a>  для активации аккаунта: ",
                    email);
            return "ok";
        } else {
            return "failed";
        }
    }
}
