package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dz.labs.model.Addresses;
import ru.dz.labs.model.Telephones;
import ru.dz.labs.model.Users;
import ru.dz.labs.services.AddressesService;
import ru.dz.labs.services.TelephoneService;
import ru.dz.labs.services.UsersService;
import ru.dz.labs.util.Methods;

@Controller
public class AccountEditController extends BaseController {
    @Autowired
    UsersService usersService;
    @Autowired
    TelephoneService telephoneService;
    @Autowired
    AddressesService addressesService;


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String renderEditPage() {
        return "pages/accountEdit";
    }


    /**
     * Приходят параметры, проверям, пусты или не пусты
     * Не пустые соответствующе обрабатываем
     */
    @ResponseBody
    @RequestMapping(value = "/edit_name", method = RequestMethod.POST)
    public String updateUsersName(String userEditName) {
        Users user = (Users) request.getSession().getAttribute("user");
        usersService.updateNameOfUserById(user.getId(), userEditName);

        request.getSession().setAttribute("user", usersService.getUsersById(user.getId()));

        user = (Users) request.getSession().getAttribute("user");
        System.out.println(user.getName());

        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/edit_avatar", method = RequestMethod.POST)
    public String updateUsersAvatar(String userEditAvatar) {
        Users user = (Users) request.getSession().getAttribute("user");
        usersService.updateAvatarOfUserById(user.getId(), userEditAvatar);

        request.getSession().setAttribute("user", usersService.getUsersById(user.getId()));

        user = (Users) request.getSession().getAttribute("user");
        System.out.println(user.getName());

        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/edit_telephone", method = RequestMethod.POST)
    public String addUsersTelephone(String userEditTelephone) {
        Users user = (Users) request.getSession().getAttribute("user");
        telephoneService.addTelephone(new Telephones(userEditTelephone, user));
        request.getSession().setAttribute("user", usersService.getUsersById(user.getId()));

        user = (Users) request.getSession().getAttribute("user");
        System.out.println(user.getName());

        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/edit_address", method = RequestMethod.POST)
    public String addUsersAddress(String userEditAddress) {
        Users user = (Users) request.getSession().getAttribute("user");
        addressesService.addAddresses(new Addresses(userEditAddress, user));

        request.getSession().setAttribute("user", usersService.getUsersById(user.getId()));

        user = (Users) request.getSession().getAttribute("user");
        System.out.println(user.getName());

        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/edit_pass", method = RequestMethod.POST)
    public String updateUsersInfo(String userEditOldPass, String userEditNewPass) {
        Users user = (Users) request.getSession().getAttribute("user");
        if (checkNotNullPasswords(userEditOldPass, userEditNewPass)) {
            if (Methods.passToHash(userEditOldPass).equals(user.getHash_pass())) {
                usersService.updatePasswordOfUserById(user.getId(), userEditNewPass);
                request.getSession().setAttribute("user", usersService.getUsersById(user.getId()));
                user = (Users) request.getSession().getAttribute("user");
                System.out.println(user.getName());
                return "ok";
            }
        }
        return "false";
    }


    private boolean checkNotNullPasswords(String userEditOldPass, String userEditNewPass) {
        return Methods.checkOfNull(userEditOldPass) && Methods.checkOfNull(userEditNewPass);
    }

    private void addToString(StringBuilder stringBuilder, String s) {
        stringBuilder.append(s);
    }

}
