package ru.dz.labs.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.model.Categories;
import ru.dz.labs.model.Goods;
import ru.dz.labs.services.CategoriesService;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GoodsRepository {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CategoriesService categoriesService;

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

    public List getGoodsAfterFilter(Float priceBegin, Float priceEnd, Long category) {
        Criteria criteriaGoods = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        if (priceBegin == null && priceEnd == null && category == null)
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
                List<Categories> categoriesQueue = new ArrayList<>();
                List<Categories> categorySons;
                Categories removeCat;

                categoriesQueue.add(categoriesService.getCategoryById(category));

                Disjunction disjunction = Restrictions.disjunction();
                while (!categoriesQueue.isEmpty()) {
                    removeCat = categoriesQueue.remove(0);
                    categorySons = categoriesService.getCategorySons(removeCat);
                    categoriesQueue.addAll(categorySons);
                    disjunction.add(Restrictions.eq("categories", removeCat));
                }
                criteriaGoods.add(disjunction);
            }
            return criteriaGoods.list();
        }
    }
}