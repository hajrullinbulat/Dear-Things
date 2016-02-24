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

    @Transactional
    public Goods getGoodById(Long id){
        return goodsRepository.getGoodById(id);
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
