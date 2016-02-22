package ru.dz.labs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.model.Orders;
import ru.dz.labs.repository.OrdersRepository;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    @Transactional
    public void addOrders(Orders orders) {
        ordersRepository.add(orders);
    }
}
