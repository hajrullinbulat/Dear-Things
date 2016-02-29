package ru.dz.labs;

import org.springframework.beans.factory.annotation.Autowired;
import ru.dz.labs.services.GoodsService;

public class Pagination {
    @Autowired
    GoodsService goodsService;

    private Integer countOfGoods;

    private Integer nowPage;

    private Integer goodsPerPage;

    private Integer beginIndex = nowPage * goodsPerPage - goodsPerPage;

    public Pagination(Integer countOfGoods, Integer nowPage,Integer goodsPerPage) {
        this.countOfGoods = countOfGoods;
        this.nowPage = nowPage;
        this.goodsPerPage = goodsPerPage;
    }

    private Integer endIndex = nowPage * goodsPerPage;

    private Integer totalPages = countOfGoods / goodsPerPage;


    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    public Integer getBeginIndex() {
        return beginIndex;
    }

    public void setBeginIndex(Integer beginIndex) {
        this.beginIndex = beginIndex;
    }

    public Integer getGoodsPerPage() {
        return goodsPerPage;
    }

    public void setGoodsPerPage(Integer goodsPerPage) {
        this.goodsPerPage = goodsPerPage;
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public Integer getCountOfGoods() {
        return countOfGoods;
    }

    public void setCountOfGoods(Integer countOfGoods) {
        this.countOfGoods = countOfGoods;
    }
}
