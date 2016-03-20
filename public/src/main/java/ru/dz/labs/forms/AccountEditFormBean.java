package ru.dz.labs.forms;

import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

public class AccountEditFormBean {

    @Pattern(regexp = "^([A-Z][a-z]{1,15}\\s[A-Z][a-z]{1,15})|([А-Я][а-я]{1,15}\\s[А-Я][а-я]{1,15})$",
            message = "Формат: Костя Косточкин")
    private String name;

    private String phone;

    private String oldPassword;

    private String newPassword;

    private String address;

    private String avatar;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public AccountEditFormBean(String name, String phone, String oldPassword, String newPassword, String address, String avatar) {

        this.name = name;
        this.phone = phone;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.address = address;
        this.avatar = avatar;
    }

    public AccountEditFormBean() {

    }
}
