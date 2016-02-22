package ru.dz.labs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.model.Users;
import ru.dz.labs.repository.UsersRepository;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public void addUsers(Users users){
        usersRepository.add(users);
    }

    @Transactional
    public Users getUsersById(Long id){
        return usersRepository.getUsersById(id);
    }

     @Transactional
    public List<Users> getAllUsers(){
         return usersRepository.getAllUsers();
     }
}
