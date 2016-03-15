package ru.dz.labs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
public class RegistrationController extends BaseController {
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String renderMyItemPage() {
        return "pages/registration";
    }

    @ResponseBody
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String checkValidation(String userName, String userEmail, String userPass, String userPassAgain) {
//        String userName = request.getParameter("user_name");
//        String userEmail = request.getParameter("user_email");
//        String userPass = request.getParameter("user_pass");
//        String userPassAgain = request.getParameter("user_pass_again");
        String ans = checkValid(userName, userEmail, userPass, userPassAgain);
        return ans;
    }

    private String checkValid(String userName, String userEmail, String userPass, String userPassAgain) {
        String ans = "";
        if (userName == null) {
            ans = ans + "user_name null ";
        } else {
            Pattern p = Pattern.compile("(([А-Я][а-я]{1,15}\\s[А-Я][а-я]{1,15})|([A-Z][a-z]{1,15}\\s[A-Z][a-z]{1,15}))");
            Matcher m = p.matcher(userName);
            if (!m.matches()) {
                ans = ans + "user_name no ";
            }
        }
        if (userPass == null || userPassAgain == null) {
            ans = ans + "user_pass null ";
        } else {
            if (!userPass.equals(userPassAgain)) {
                ans = ans + "user_pass no ";
            }
        }
        if (userEmail == null) {
            ans = ans + "user_email null ";
        } else {
            Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher m = p.matcher(userEmail);
            if (!m.matches()) {
                ans = ans + "user_email no ";
            }
        }
        if (ans.equals("")) {
            return "ok";
        } else {
            return ans;
        }
    }


}
