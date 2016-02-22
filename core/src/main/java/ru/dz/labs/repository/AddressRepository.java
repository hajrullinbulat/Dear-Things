package ru.dz.labs.repository;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.labs.model.Addresses;

@Repository
public class AddressRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(Addresses addresses) {
        sessionFactory.getCurrentSession().save(addresses);
    }
}
