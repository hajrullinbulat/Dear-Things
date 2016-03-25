package ru.dz.labs.repository;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.model.Carts;
import ru.dz.labs.model.Goods;
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
        return (Carts) sessionFactory.getCurrentSession().get(Carts.class, id);
    }

    public List getUserCart(Users user) {
        return sessionFactory.getCurrentSession().createCriteria(Carts.class)
                .add(Restrictions.eq("users", user)).list();
    }

    public void deleteFromCart(Long id) {
        sessionFactory.getCurrentSession().createQuery("delete Carts c where c.id = :id")
                .setLong("id", id).executeUpdate();
    }

    public Carts getCart(Users users, Goods good) {
        return (Carts) sessionFactory.getCurrentSession().createCriteria(Carts.class)
                .add(Restrictions.eq("users", users))
                .add(Restrictions.eq("goods", good)).uniqueResult();
    }

    public void updateCountOfCart(Long cartId, Integer count) {
        sessionFactory.getCurrentSession().createQuery("update Carts c set c.count = :count where c.id =:id")
                .setInteger("count", count)
                .setLong("id", cartId)
                .executeUpdate();
    }

}
