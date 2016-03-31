package ru.dz.labs.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.dz.labs.model.Users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetail implements UserDetails {

    /**
     * запись о пользователе из БД
     */
    private Users user;

    public MyUserDetail(Users user) {
        this.user = user;
    }

    /**
     * @return коллекция прав доступа пользователя
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
        return grantedAuthorities;
    }

    /**
     * hash пароля пользователя
     */
    @Override
    public String getPassword() {
        return user.getHash_pass();
    }

    /**
     * Логин (имя) пользователя
     */
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    /**
     * @return флаг, что срок действия аккаунта еще не истек, он активен
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * @return флаг, что пользователь не заблокирован администраторами сайта
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * @return флаг, что срок действия пароля еще не истек, он активен
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * @return флаг, что пользователь включен и подтвержден
     */
    @Override
    public boolean isEnabled() {
        return user.getEnabled();
    }

    public Users getUserInfo() {
        return user;
    }

    public void setUserInfo(Users user) {
        this.user = user;
    }

    public MyUserDetail() {
    }
}
