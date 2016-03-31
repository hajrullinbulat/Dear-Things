package ru.dz.labs.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String addresses;
    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "addresses")
    private List<Orders> orders;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddresses() {
        return addresses;
    }

    public Addresses(String addresses, Users users) {
        this.addresses = addresses;
        this.users = users;
    }

    public void setAddresses(String address) {
        this.addresses = address;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Addresses(String addresses, Users users, List<Orders> orders) {
        this.addresses = addresses;
        this.users = users;
        this.orders = orders;
    }

    public Addresses() {

    }
}
