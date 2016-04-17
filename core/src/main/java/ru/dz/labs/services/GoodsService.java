package ru.dz.labs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.model.Categories;
import ru.dz.labs.model.Goods;
import ru.dz.labs.pojo.Filter;
import ru.dz.labs.repository.CategoriesRepository;
import ru.dz.labs.repository.GoodsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Transactional
    public void addGoods(Goods goods) {
        goodsRepository.add(goods);
    }

    @Transactional
    public Goods getGoodById(Long id) {
        return goodsRepository.getGoodById(id);
    }

    /**
     * берем предметы из той же категории, что и предмет, если меньше 4,
     * то поднимаемся выше по дереву(пока не наберем 4 предмета или не достигнем верха)
     */
    @Transactional
    public List getLikeGoods(Goods good) {
        Categories category = good.getCategories();
        Long id = good.getId();
        List likeGoods = goodsRepository.getLikeGoods(category, 4, id);
        int size = likeGoods.size();
        if (size == 4) {
            return likeGoods;
        } else {
            while (category.getId() != 1 && size < 4) {
                category = category.getParent();
                likeGoods.addAll(goodsRepository.getLikeGoods(category, 4 - size, id));
                size = likeGoods.size();
            }
        }
        return likeGoods;
    }

    @Transactional
    public List getGoodsFromCookie(String goods) {
        String[] goodsIds = goods.split(",");
        List<Goods> cart = new ArrayList<>();
        for (String s : goodsIds) {
            cart.add(goodsRepository.getGoodById(Long.valueOf(s)));
        }
        return cart;
    }


    @Transactional
    public List getGoodsAfterFilter(Filter filter) {
        Categories category = filter.getCategory();
        return goodsRepository.getGoodsAfterFilter(filter.getPriceBegin(),
                filter.getPriceEnd(),
                category,
                categoriesRepository.getCategoryTree(category),
                filter.getSort());
    }

    @Transactional
    public List getGoodsToMain() {
        return goodsRepository.getGoodsToMain();
    }
}
