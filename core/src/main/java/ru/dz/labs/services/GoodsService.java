package ru.dz.labs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.model.Goods;
import ru.dz.labs.repository.GoodsRepository;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    @Transactional
    public void addGoods(Goods goods) {
        goodsRepository.add(goods);
    }

    @Transactional
    public List<Goods> getAllGoods() {
        return goodsRepository.getAllGoods();
    }

}
