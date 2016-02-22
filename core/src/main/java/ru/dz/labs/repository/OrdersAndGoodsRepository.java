package ru.dz.labs.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.model.Orders_Goods;

@Repository
public class OrdersAndGoodsRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Orders_Goods orders_goods) {
        sessionFactory.getCurrentSession().save(orders_goods);
    }
}
