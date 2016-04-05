package ru.dz.labs.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.model.OrderGoods;
import ru.dz.labs.model.Orders;

@Repository
public class OrderGoodsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(OrderGoods orderGoods) {
        sessionFactory.getCurrentSession().save(orderGoods);
    }

    public void deleteOrderGoods(Orders order) {
        sessionFactory.getCurrentSession().createQuery("delete OrderGoods o where o.orders = :order")
                .setEntity("order", order).executeUpdate();
    }
}
