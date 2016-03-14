package ru.dz.labs.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
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

    public Goods getGoodById(Long id) {
        return (Goods) sessionFactory.getCurrentSession().load(Goods.class, id);
    }

    public List getLikeGoods(Categories category, Integer num, Long goodId) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Goods.class)
                .add(Restrictions.eq("categories", category))
                .add(Restrictions.ne("id", goodId))
                .setMaxResults(num);
        return criteria.list();
    }

    public List getGoodsAfterFilter(Float priceBegin, Float priceEnd, Long category, List<Categories> tree, String sort) {
        Criteria criteriaGoods = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        if (priceBegin == null && priceEnd == null && category == null && sort == null)
            return criteriaGoods.list();
        else {
            if (priceBegin == null && priceEnd == null) {
            } else {
                if (priceBegin != null && priceEnd != null)
                    criteriaGoods.add(Restrictions.between("price", priceBegin, priceEnd));
                else if (priceBegin != null)
                    criteriaGoods.add(Restrictions.ge("price", priceBegin));
                else
                    criteriaGoods.add(Restrictions.le("price", priceEnd));
            }
            if (category != null) {
                Disjunction disjunction = Restrictions.disjunction();
                for (Categories cat : tree) {
                    disjunction.add(Restrictions.eq("categories", cat));
                }
                criteriaGoods.add(disjunction);
            }
            if (sort != null) {
                if (sort.equals("min"))
                    criteriaGoods.addOrder(Order.asc("price"));
                else if (sort.equals("max"))
                    criteriaGoods.addOrder(Order.desc("price"));
            }
            return criteriaGoods.list();
        }
    }
}