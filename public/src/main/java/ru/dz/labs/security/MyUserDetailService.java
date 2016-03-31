package ru.dz.labs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.dz.labs.model.Users;
import ru.dz.labs.services.UsersService;


@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = usersService.getUserByEmail(email);
        if (user == null) throw new UsernameNotFoundException("User with email " + email + " not found");
        return new MyUserDetail(user);
    }

}
