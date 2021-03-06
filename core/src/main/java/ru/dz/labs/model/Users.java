package ru.dz.labs.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Users {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String email;
    private String hash_pass;
    private String avatar;
    private String name;
    private Boolean enabled;
    private String key;
    private String role;

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
    private List<Telephones> telephones;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "users")
    private List<Orders> orders;

    public Users() {
    }

    public Users(String email, String hash_pass, String name, Boolean enabled, String key, String role) {
        this.email = email;
        this.hash_pass = hash_pass;
        this.name = name;
        this.enabled = enabled;
        this.key = key;
        this.role = role;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public List<Telephones> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephones> telephones) {
        this.telephones = telephones;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Users(String email, String hash_pass, String avatar, String name, Boolean enabled, String key, String role, List<Carts> carts, List<Addresses> addresses, List<Telephones> telephones, List<Orders> orders) {

        this.email = email;
        this.hash_pass = hash_pass;
        this.avatar = avatar;
        this.name = name;
        this.enabled = enabled;
        this.key = key;
        this.role = role;
        this.carts = carts;
        this.addresses = addresses;
        this.telephones = telephones;
        this.orders = orders;
    }
}
