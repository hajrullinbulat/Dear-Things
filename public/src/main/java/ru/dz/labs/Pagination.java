package ru.dz.labs;

public class Pagination {

    private Integer countOfGoods;

    private Integer nowPage;

    private Integer goodsPerPage;

    private Integer beginIndex;

    private Integer endIndex;

    private Integer totalPages;

    public Pagination(Integer countOfGoods, Integer nowPage, Integer goodsPerPage) {
        this.countOfGoods = countOfGoods;
        this.nowPage = nowPage;
        this.goodsPerPage = goodsPerPage;

        makeRight(nowPage, goodsPerPage, countOfGoods);
    }

    private void makeRight(Integer nowPage, Integer goodsPerPage, Integer countOfGoods) {
        setBeginIndex(nowPage * goodsPerPage - goodsPerPage);
        setEndIndex(nowPage * goodsPerPage);
        setTotalPages(countOfGoods / goodsPerPage);
    }

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
        makeRight(nowPage, getGoodsPerPage(), getCountOfGoods());
    }

    public Integer getCountOfGoods() {
        return countOfGoods;
    }

    public void setCountOfGoods(Integer countOfGoods) {
        this.countOfGoods = countOfGoods;
    }
}
