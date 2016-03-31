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
    public void addToCart(Users user, Long goodId) {
        cartsRepository.add(new Carts(goodsService.getGoodById(goodId), user, 1));
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
        cartsRepository.deleteFromCart(id);
    }

    @Transactional
    public boolean checkOfExistingItemInCart(Users user, Long goodId) {
        Carts cart = cartsRepository.getCart(user, goodsService.getGoodById(goodId));
        return null != cart;
    }

    @Transactional
    public void updateCountOfCart(Long cartId, Integer count) {
        cartsRepository.updateCountOfCart(cartId, count);
    }

    @Transactional
    public List getSumOfCartByUserId(Users user) {
        return cartsRepository.getSumOfCartByUser(user);
    }

    @Transactional
    public void deleteCartsByUser(Users user){
        cartsRepository.deleteCartsByUser(user);
    }

}
