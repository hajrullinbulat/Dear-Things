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
        return (Categories) sessionFactory.getCurrentSession().load(Categories.class, id);
    }

    public List getCategorySons(Categories categories) {
        return sessionFactory.getCurrentSession().createCriteria(Categories.class)
                .add(Restrictions.eq("parent", categories))
                .add(Restrictions.ne("id", categories.getId()))
                .list();
    }

    public List getAllCategories() {
        return sessionFactory.getCurrentSession().createCriteria(Categories.class).list();
    }

    public List getCategoryTree(Categories category) {
//        List<Categories> categoryTree = new ArrayList<>();
//        List<Categories> listToRemove = new ArrayList<>();
//        Categories removeCat;
//
//        categoryTree.add(category);
//        listToRemove.add(category);
//
//        while (!listToRemove.isEmpty()) {
//
//        }

        List<Categories> allCategories = getAllCategories();
        List<Categories> tree = new ArrayList<>();
        List<Categories> remove = new ArrayList<>();
        Categories catToRem;
        remove.add(category);
        tree.add(category);


        while (!remove.isEmpty()) {
            catToRem = remove.remove(0);
            remove.addAll(getCategorySonsWithoutDB(allCategories, catToRem));

        }

    }

    public List getCategorySonsWithoutDB(List<Categories> allCategories, Categories category) {
        List<Categories> list = new ArrayList<>();
        for (Categories cat : allCategories) {
            if (cat.getParent().equals(category)) {
                list.add(cat);
            }
        }
        return list;
    }
}
