package ru.dz.labs.pojo;

import ru.dz.labs.model.Categories;

/**
 * фильтр сортировки отображаемых товаров
 */
public class Filter {
    Categories category;
    Float priceBegin;
    Float priceEnd;
    String sort;

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public Float getPriceBegin() {
        return priceBegin;
    }

    public Float getPriceEnd() {
        return priceEnd;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Filter() {

    }

    public void setPrices(String priceBegin, String priceEnd) {
        if (priceBegin != null && priceEnd != null) {
            try {
                Float priceB = Float.valueOf(priceBegin);
                Float priceE = Float.valueOf(priceEnd);
                if (priceB < priceE || (priceB == 0 && priceE == 0)) {
                    this.priceBegin = priceB;
                    this.priceEnd = priceE;
                }
            } catch (NumberFormatException ignored) {
            }

        }
    }

}
