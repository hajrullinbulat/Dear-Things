package ru.dz.labs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.model.Carts;
import ru.dz.labs.repository.CartsRepository;

import javax.servlet.http.HttpSession;

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
}
