package ru.dz.labs.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.model.Orders;

@Repository
public class OrdersRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(Orders orders) {
        sessionFactory.getCurrentSession().save(orders);
    }
}
