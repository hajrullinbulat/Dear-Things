package ru.dz.labs.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.model.Carts;

@Repository
public class CartsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(Carts carts) {
        sessionFactory.getCurrentSession().save(carts);
    }

    public Carts getCartsById(Long id){
        return (Carts) sessionFactory.getCurrentSession().load(Carts.class, id);
    }


}
