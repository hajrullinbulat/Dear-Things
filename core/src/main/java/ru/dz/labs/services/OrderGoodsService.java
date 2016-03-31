package ru.dz.labs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.model.Carts;
import ru.dz.labs.model.OrderGoods;
import ru.dz.labs.model.Orders;
import ru.dz.labs.repository.OrderGoodsRepository;

import java.util.List;

@Service
public class OrderGoodsService {

    @Autowired
    OrderGoodsRepository orderGoodsRepository;

    @Transactional
    public void addOrderGoods(Orders orders, List<Carts> carts) {
        for (Carts c : carts)
            orderGoodsRepository.add(new OrderGoods(c.getCount(), orders, c.getGoods()));
    }

}
