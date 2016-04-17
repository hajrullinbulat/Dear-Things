package ru.dz.labs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import ru.dz.labs.model.Users;
import ru.dz.labs.repository.UsersRepository;
import ru.dz.labs.util.Methods;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public Users getUserByEmail(String email) {
        return usersRepository.getUserByEmail(email);
    }

    @Transactional
    public void addUsers(String name, String email, String pass) {
        Users users = new Users(email, DigestUtils.md5DigestAsHex(pass.getBytes()), name, false, Methods.keyGen(), "ROLE_USER");
        usersRepository.add(users);
    }

    @Transactional
    public Users getUsersById(Long id) {
        return usersRepository.getUsersById(id);
    }

    @Transactional
    public boolean checkEmail(String email) {
        return usersRepository.checkEmail(email);
    }

    @Transactional
    public Users checkLogging(String email, String pass) {
        return usersRepository.checkLogging(email, DigestUtils.md5DigestAsHex(pass.getBytes()));
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

    @Transactional
    public void activateAccount(String key){
        usersRepository.activateAccount(key);
    }
}
