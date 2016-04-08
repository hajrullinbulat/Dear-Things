package ru.dz.labs.repository;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.model.Categories;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoriesRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(Categories categories) {
        sessionFactory.getCurrentSession().save(categories);
    }

    public Categories getCategoryById(Long id) {
        return (Categories) sessionFactory.getCurrentSession().get(Categories.class, id);
    }

    public List getCategorySons(Categories categories) {
        return sessionFactory.getCurrentSession().createCriteria(Categories.class)
                .add(Restrictions.eq("parent", categories))
                .add(Restrictions.ne("id", categories.getId()))
                .list();
    }

    public List getCategoryTree(Categories categories) {
        if (categories != null) {
            List<Categories> tree = new ArrayList<>();
            tree.add(categories);
            for (int i = 0; i < tree.size(); i++) {
                tree.addAll(getCategorySons(tree.get(i)));
            }
            return tree;
        } else {
            return null;
        }
    }

    public List getMainCategories() {
        Categories categoryById = getCategoryById(1L);
        return sessionFactory.getCurrentSession().createCriteria(Categories.class).add(Restrictions.eq("parent", categoryById)).list();
    }

    public List getAllCategories(){
        return sessionFactory.getCurrentSession().createCriteria(Categories.class).list();
    }
}
