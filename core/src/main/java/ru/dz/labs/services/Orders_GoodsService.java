package ru.dz.labs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.model.Orders_Goods;
import ru.dz.labs.repository.OrdersAndGoodsRepository;

@Service
public class Orders_GoodsService {
    @Autowired
    private OrdersAndGoodsRepository ordersAndGoodsRepository;

    @Transactional
    public void addOrderAndGoods(Orders_Goods orders_goods){
        ordersAndGoodsRepository.add(orders_goods);
    }
}
