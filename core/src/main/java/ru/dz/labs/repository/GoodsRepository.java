package ru.dz.labs.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.model.Categories;
import ru.dz.labs.model.Goods;

import java.util.List;

@Repository
public class GoodsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(Goods goods) {
        sessionFactory.getCurrentSession().save(goods);
    }

    public List getAllGoods() {
        return sessionFactory.getCurrentSession().createCriteria(Goods.class).list();
    }

    public Goods getGoodById(Long id) {
        return (Goods) sessionFactory.getCurrentSession().load(Goods.class, id);
    }

    public List getLikeGoods(Categories category, Integer num, Long goodId) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Goods.class)
                .add(Restrictions.eq("categories",category))
                .add(Restrictions.ne("id", goodId))
                .setMaxResults(num);
        return criteria.list();
    }

}
