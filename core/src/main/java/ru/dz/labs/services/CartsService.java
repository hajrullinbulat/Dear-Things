package ru.dz.labs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.model.Carts;
import ru.dz.labs.model.Users;
import ru.dz.labs.pojo.SumAndCount;
import ru.dz.labs.repository.CartsRepository;

import java.util.List;

@Service
public class CartsService{

    @Autowired
    private CartsRepository cartsRepository;
    @Autowired
    private GoodsService goodsService;

    @Transactional
    public void addToCart(Users user, Long goodId) {
        cartsRepository.add(new Carts(goodsService.getGoodById(goodId), user, 1));
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
        return null != cartsRepository.getCart(user, goodsService.getGoodById(goodId));
    }

    @Transactional
    public void updateCountOfCart(Long cartId, Integer count) {
        cartsRepository.updateCountOfCart(cartId, count);
    }

    @Transactional
    public SumAndCount getSumAndCountOfCartByUserId(Users user) {
        Object[] sumOfCartByUser = cartsRepository.getSumOfCartByUser(user);
        if (sumOfCartByUser[0] != null) {
            return new SumAndCount(sumOfCartByUser[0].toString(), sumOfCartByUser[1].toString());
        } else {
            return new SumAndCount("0", "0");
        }
    }

    @Transactional
    public void deleteCartsByUser(Users user) {
        cartsRepository.deleteCartsByUser(user);
    }

    @Transactional
    public void toCartFromCook(Users user, String[] goods) {
        for (String good : goods) {
            Long goodId = Long.valueOf(good);
            if (!checkOfExistingItemInCart(user, goodId))
                addToCart(user, goodId);
        }
    }
}
