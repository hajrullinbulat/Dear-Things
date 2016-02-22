package ru.dz.labs.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Goods {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer year; //вопрос
    private String made;
    private float price;
    private Integer count;
    private String size;
    private String image;
    private String description;
    private String color;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Categories categories;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "goods")
    private List<Carts> carts;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "goods")
    private List<Orders_Goods> orders_goods;

    public Long getId() {
        return id;
    }

    public Goods() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public List<Carts> getCarts() {
        return carts;
    }

    public void setCarts(List<Carts> carts) {
        this.carts = carts;
    }

    public List<Orders_Goods> getOrders_goods() {
        return orders_goods;
    }

    public void setOrders_goods(List<Orders_Goods> orders_goods) {
        this.orders_goods = orders_goods;
    }

    public Goods(String name, Integer year, String made, float price, Integer count, String size, String image, String description, String color, Categories categories, List<Carts> carts, List<Orders_Goods> orders_goods) {
        this.name = name;
        this.year = year;
        this.made = made;
        this.price = price;
        this.count = count;
        this.size = size;
        this.image = image;
        this.description = description;
        this.color = color;
        this.categories = categories;
        this.carts = carts;
        this.orders_goods = orders_goods;
    }
}
