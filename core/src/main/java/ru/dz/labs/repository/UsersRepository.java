package ru.dz.labs.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.model.Users;

import java.util.List;

@Repository
public class UsersRepository {


    @Autowired
    private SessionFactory sessionFactory;

    public void add(Users users) {
        sessionFactory.getCurrentSession().save(users);
    }

    public Users getUsersById(Long id) {
        return (Users) sessionFactory.getCurrentSession().load(Users.class, id);
    }

    public List<Users> getAllUsers() {
        return sessionFactory.getCurrentSession().createCriteria(Users.class).list();
    }
}
