package ru.dz.labs.pojo;

/**
 * для отображения суммы и кол-ва элементов в корзине
 */
public class SumAndCount {
    Float sum;
    Integer count;

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public SumAndCount(String sum, String count) {
        this.sum = Float.valueOf(sum);
        this.count = Integer.valueOf(count);
    }
}
