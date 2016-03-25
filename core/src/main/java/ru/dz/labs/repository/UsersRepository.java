package ru.dz.labs.repository;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.model.Users;

import java.util.List;

@Repository
public class UsersRepository {


    @Autowired
    private SessionFactory sessionFactory;

    public void add(Users user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public Users getUsersById(Long id) {
        return (Users) sessionFactory.getCurrentSession().get(Users.class, id);
    }

    public List<Users> getAllUsers() {
        return sessionFactory.getCurrentSession().createCriteria(Users.class).list();
    }

    public boolean checkEmail(String email) {
        return sessionFactory.getCurrentSession().createCriteria(Users.class).add(Restrictions.eq("email", email)).list().size() == 0;
    }

    public Users checkLogging(String email, String pass) {
        return (Users) sessionFactory.getCurrentSession().createCriteria(Users.class)
                .add(Restrictions.eq("email", email))
                .add(Restrictions.eq("hash_pass", pass))
                .uniqueResult();
    }

    public void updateNameOfUserById(Long id, String name) {
        sessionFactory.getCurrentSession().createQuery("update Users u set u.name = :newName where u.id = :id")
                .setString("newName", name)
                .setLong("id", id)
                .executeUpdate();
    }

    public void updateAvatarOfUserById(Long id, String avatar) {
        sessionFactory.getCurrentSession().createQuery("update Users u set u.avatar = :newAvatar where u.id = :id")
                .setString("newAvatar", avatar)
                .setLong("id", id)
                .executeUpdate();
    }

    public void updatePasswordOfUserById(Long id, String newPass) {
        sessionFactory.getCurrentSession().createQuery("update Users u set u.hash_pass = :newPass where u.id = :id")
                .setString("newPass", newPass)
                .setLong("id", id)
                .executeUpdate();
    }
}
