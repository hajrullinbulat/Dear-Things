package ru.dz.labs.model;

import javax.persistence.*;

@Entity
@Table(name = "order_goods")
public class OrderGoods {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "good_id")
    private Goods goods;

    @ManyToOne
            (cascade = {CascadeType.REFRESH}
                    , fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders orders;

    private Integer count;

    public OrderGoods() {
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public OrderGoods(Integer count, Orders orders, Goods goods) {

        this.count = count;
        this.orders = orders;
        this.goods = goods;
    }
}