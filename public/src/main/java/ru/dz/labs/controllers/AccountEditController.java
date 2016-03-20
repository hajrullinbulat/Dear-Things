package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editForm(String userEditName, String userEditAvatar, String userEditTelephone, String userEditAddress, String userEditOldPass, String userEditNewPass) {
        String ans = "";
        Users user = (Users) request.getSession().getAttribute("user");
        if (null != userEditName && !userEditName.equals("")) {
            usersService.updateNameOfUserById(user.getId(), userEditName);
            ans = ans + "name ";
        }
        if (null != userEditAvatar && !userEditAvatar.equals("")) {
            usersService.updateAvatarOfUserById(user.getId(), userEditAvatar);
            ans = ans + "avatar ";
        }
        if (null != userEditTelephone && !userEditTelephone.equals("")) {
            telephoneService.addTelephone(new Telephones(userEditTelephone, user));
            ans = ans + "tel ";
        }
        if (null != userEditAddress && !userEditAddress.equals("")) {
            addressesService.addAddresses(new Addresses(userEditAddress, user));
            ans = ans + "address ";
        }
        if (null != userEditOldPass && !userEditOldPass.equals("")
                && null != userEditNewPass && !userEditNewPass.equals("")) {
            if (DigestUtils.md5DigestAsHex(userEditOldPass.getBytes()).equals(user.getHash_pass())) {
                usersService.updatePasswordOfUserById(user.getId(), userEditNewPass);
                ans = ans + "pass ";
            } else {
                ans = ans + "fail";
            }
        }

        Users usersById = usersService.getUsersById(user.getId());
        request.getSession().setAttribute("user", usersById);

        Users user1 = (Users) request.getSession().getAttribute("user");
        System.out.println(user1.getName());
        return ans;
    }
}
