package ru.dz.labs.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Telephones {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String telephones;
    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "telephones")
    private List<Orders> orders;

    public Telephones(String telephones, Users users) {
        this.telephones = telephones;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelephones() {
        return telephones;
    }

    public void setTelephones(String telephone) {
        this.telephones = telephone;
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

    public Telephones(String telephones, Users users, List<Orders> orders) {
        this.telephones = telephones;
        this.users = users;
        this.orders = orders;
    }

    public Telephones() {

    }
}
