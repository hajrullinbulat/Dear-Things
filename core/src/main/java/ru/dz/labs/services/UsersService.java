package ru.dz.labs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import ru.dz.labs.model.Users;
import ru.dz.labs.repository.UsersRepository;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public void addUsers(String name, String email, String pass) {
        Users users = new Users(email, DigestUtils.md5DigestAsHex(pass.getBytes()), name, false, keyGen());
        //// TODO: 18.03.2016 ОТПРАВЛЕНИЕ АКТИВИРОВАНИЯ НА ПОЧТУ
        usersRepository.add(users);
    }

    @Transactional
    public Users getUsersById(Long id) {
        return usersRepository.getUsersById(id);
    }

    @Transactional
    public List<Users> getAllUsers() {
        return usersRepository.getAllUsers();
    }

    @Transactional
    public boolean checkEmail(String email) {
        return usersRepository.checkEmail(email);
    }

    @Transactional
    public Users checkLogging(String email, String pass) {
        return usersRepository.checkLogging(email, DigestUtils.md5DigestAsHex(pass.getBytes()));
    }

    private String keyGen() {
        String letters = "abcdefghijklmnopqrstuvwxyz0123456789";
        char[] keyGen = new char[letters.length()];
        for (int i = 0; i < letters.length(); i++) {
            keyGen[i] = letters.charAt((int) (Math.random() * letters.length()));
        }

        return String.valueOf(keyGen);
    }

    @Transactional
    public void updateNameOfUserById(Long id, String name) {
        usersRepository.updateNameOfUserById(id, name);
    }

    @Transactional
    public void updateAvatarOfUserById(Long id, String avatar) {
        usersRepository.updateAvatarOfUserById(id, avatar);
    }

    @Transactional
    public void updatePasswordOfUserById(Long id, String newPassword) {
        usersRepository.updatePasswordOfUserById(id, DigestUtils.md5DigestAsHex(newPassword.getBytes()));
    }
}
