package ru.dz.labs.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date create_time;
    private Float total_sum;
    private Integer total_count;
    private String pay_type;
    private String delivery_type;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "orders")
    private List<OrderGoods> orderGoods;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Addresses addresses;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "telephone_id")
    private Telephones telephones;


    public List<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Float getTotal_sum() {
        return total_sum;
    }

    public void setTotal_sum(Float total_sum) {
        this.total_sum = total_sum;
    }

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getDelivery_type() {
        return delivery_type;
    }

    public void setDelivery_type(String delivery_type) {
        this.delivery_type = delivery_type;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Addresses getAddresses() {
        return addresses;
    }

    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }

    public Telephones getTelephones() {
        return telephones;
    }

    public void setTelephones(Telephones telephones) {
        this.telephones = telephones;
    }

    public Orders(Date create_time, Float total_sum, Integer total_count, String pay_type, String delivery_type, Users users, Addresses addresses, Telephones telephones) {
        this.create_time = create_time;
        this.total_sum = total_sum;
        this.total_count = total_count;
        this.pay_type = pay_type;
        this.delivery_type = delivery_type;
        this.users = users;
        this.addresses = addresses;
        this.telephones = telephones;
    }

    public Orders() {

    }
}
