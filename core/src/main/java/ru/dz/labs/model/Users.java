package ru.dz.labs.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Users {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String hash_pass;
    private String avatar;
    private String name;
    private String check_email;
    private String key;


    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "users")
    private List<Carts> carts;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "users")
    private List<Addresses> addresses;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "users")
    private List<Orders> orders;

    public Users() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHash_pass() {
        return hash_pass;
    }

    public void setHash_pass(String hash_pass) {
        this.hash_pass = hash_pass;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCheck_email() {
        return check_email;
    }

    public void setCheck_email(String check_email) {
        this.check_email = check_email;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Carts> getCarts() {
        return carts;
    }

    public void setCarts(List<Carts> carts) {
        this.carts = carts;
    }

    public List<Addresses> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Addresses> addresses) {
        this.addresses = addresses;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Users(String email, String hash_pass, String avatar, String name, String check_email, String key, List<Carts> carts, List<Addresses> addresses, List<Orders> orders) {

        this.email = email;
        this.hash_pass = hash_pass;
        this.avatar = avatar;
        this.name = name;
        this.check_email = check_email;
        this.key = key;
        this.carts = carts;
        this.addresses = addresses;
        this.orders = orders;
    }
}
