package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dz.labs.Methods;
import ru.dz.labs.model.Addresses;
import ru.dz.labs.model.Telephones;
import ru.dz.labs.model.Users;
import ru.dz.labs.services.AddressesService;
import ru.dz.labs.services.TelephoneService;
import ru.dz.labs.services.UsersService;

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
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String updateUsersInfo(String userEditName, String userEditAvatar,
                                  String userEditTelephone, String userEditAddress,
                                  String userEditOldPass, String userEditNewPass) {

        StringBuilder ans = new StringBuilder();
        Users user = (Users) request.getSession().getAttribute("user");

        if (Methods.checkOfNull(userEditName)) {
            usersService.updateNameOfUserById(user.getId(), userEditName);
            addToString(ans, "name ");
        }
        if (Methods.checkOfNull(userEditAvatar)) {
            usersService.updateAvatarOfUserById(user.getId(), userEditAvatar);
            addToString(ans, "avatar ");
        }
        if (Methods.checkOfNull(userEditTelephone)) {
            telephoneService.addTelephone(new Telephones(userEditTelephone, user));
            addToString(ans, "tel ");
        }
        if (Methods.checkOfNull(userEditAddress)) {
            addressesService.addAddresses(new Addresses(userEditAddress, user));
            addToString(ans, "address ");
        }
        if (checkNotNullPasswords(userEditOldPass, userEditNewPass)) {
            if (Methods.passToHash(userEditOldPass).equals(user.getHash_pass())) {
                usersService.updatePasswordOfUserById(user.getId(), userEditNewPass);
                addToString(ans, "pass ");
            } else {
                addToString(ans, "fail ");
            }
        }

        request.getSession().setAttribute("user", usersService.getUsersById(user.getId()));

        user = (Users) request.getSession().getAttribute("user");
        System.out.println(user.getName());

        return ans.toString();
    }

    private boolean checkNotNullPasswords(String userEditOldPass, String userEditNewPass) {
        return Methods.checkOfNull(userEditOldPass) && Methods.checkOfNull(userEditNewPass);
    }

    private void addToString(StringBuilder stringBuilder, String s) {
        stringBuilder.append(s);
    }

}
