package ru.dz.labs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.model.Categories;
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
    public Goods getGoodById(Long id) {
        return goodsRepository.getGoodById(id);
    }

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
    public List getGoodsAfterFilter(String category, String priceBegin, String priceEnd) {
        Long cat = null;
        Float priceB = null;
        Float priceE = null;
        if (category != null)
            cat = Long.valueOf(category);
        if (priceBegin != null)
            priceB = Float.valueOf(priceBegin);
        if (priceEnd != null)
            priceE = Float.valueOf(priceEnd);
        return goodsRepository.getGoodsAfterFilter(priceB, priceE, cat);
    }

//
//        for (Goods good : allGoods) {
//            try {
//                BufferedImage image = ImageIO.read(new File("D:\\" + good.getImage()));
//
//                int height = image.getHeight();
//                int width = image.getWidth();
//
//                if (height != width) {
//                    int temp;
//                    if (width > height) {
//                        temp = (width - height) / 2;
//                        image = image.getSubimage(temp, 0, height, height);
//                    } else {
//                        temp = (height - width) / 2;
//                        image = image.getSubimage(0, temp, width, width);
//                    }
//                    ImageIO.write(image, "JPEG", new File("D:\\resources\\images\\new\\" + good.getId() + ".jpg"));
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


}
