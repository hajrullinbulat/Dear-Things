package ru.dz.labs.repository;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.model.Carts;
import ru.dz.labs.model.Users;

import java.util.List;

@Repository
public class CartsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(Carts carts) {
        sessionFactory.getCurrentSession().save(carts);
    }

    public Carts getCartsById(Long id) {
        return (Carts) sessionFactory.getCurrentSession().load(Carts.class, id);
    }

    public List getUserCart(Users user) {
        return sessionFactory.getCurrentSession().createCriteria(Carts.class)
                .add(Restrictions.eq("users", user)).list();
    }

    public void delete(Long id) {
        sessionFactory.getCurrentSession().delete(getCartsById(id));
    }
}
