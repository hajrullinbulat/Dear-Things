package ru.dz.labs.repository;


import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.model.Telephones;

@Repository
public class TelephonesRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(Telephones telephones) {
        sessionFactory.getCurrentSession().save(telephones);
    }

    public Telephones getTelephoneByString(String telephone) {
        return (Telephones) sessionFactory.getCurrentSession().createCriteria(Telephones.class)
                .add(Restrictions.eq("telephones", telephone)).uniqueResult();
    }
}
