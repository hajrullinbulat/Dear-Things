package ru.dz.labs.repository;


import org.hibernate.SessionFactory;
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
}
