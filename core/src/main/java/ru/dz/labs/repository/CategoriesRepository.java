package ru.dz.labs.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.model.Categories;

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
}
