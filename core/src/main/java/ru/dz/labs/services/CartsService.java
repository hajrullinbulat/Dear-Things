package ru.dz.labs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.model.Carts;
import ru.dz.labs.repository.CartsRepository;

@Service
public class CartsService {

    @Autowired
    private CartsRepository cartsRepository;

    @Transactional
    public void addCarts(Carts carts) {
        cartsRepository.add(carts);
    }

    @Transactional
    public Carts getCartsById(Long id) {
        return cartsRepository.getCartsById(id);
    }
}
