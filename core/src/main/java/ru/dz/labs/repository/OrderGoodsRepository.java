package ru.dz.labs.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.model.OrderGoods;

@Repository
public class OrderGoodsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(OrderGoods orderGoods) {
        sessionFactory.getCurrentSession().save(orderGoods);
    }

}
