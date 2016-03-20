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
    private float total_sum;
    private float total_count;
    private String pay_type;

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

    public float getTotal_sum() {
        return total_sum;
    }

    public void setTotal_sum(float total_sum) {
        this.total_sum = total_sum;
    }

    public float getTotal_count() {
        return total_count;
    }

    public void setTotal_count(float total_count) {
        this.total_count = total_count;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
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

    public Orders(Date create_time, float total_sum, float total_count, String pay_type, Users users, Addresses addresses, Telephones telephones) {

        this.create_time = create_time;
        this.total_sum = total_sum;
        this.total_count = total_count;
        this.pay_type = pay_type;
        this.users = users;
        this.addresses = addresses;
        this.telephones = telephones;
    }

    public Orders() {

    }
}
