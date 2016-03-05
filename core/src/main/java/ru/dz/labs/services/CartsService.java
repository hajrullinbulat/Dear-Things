package ru.dz.labs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.model.Carts;
import ru.dz.labs.model.Users;
import ru.dz.labs.repository.CartsRepository;

import java.util.List;

@Service
public class CartsService {

    @Autowired
    private CartsRepository cartsRepository;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UsersService usersService;

    @Transactional
    public void addToCart(Long goodId, Long userId) {
        cartsRepository.add(new Carts(goodsService.getGoodById(goodId), usersService.getUsersById(userId)));
    }

    @Transactional
    public Carts getCartsById(Long id) {
        return cartsRepository.getCartsById(id);
    }

    @Transactional
    public List getUsersCart(Users user) {
        return cartsRepository.getUserCart(user);
    }

    @Transactional
    public void deleteFromCart(Long id) {
        cartsRepository.delete(id);
    }
}
