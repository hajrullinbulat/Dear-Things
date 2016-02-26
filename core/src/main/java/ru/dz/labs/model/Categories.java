package ru.dz.labs.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long parent_id;
//    @ManyToOne
//            (cascade = {CascadeType.REFRESH},
//                    fetch = FetchType.LAZY)
//    @JoinColumn(name = "id")
//    private Categories parent_id;


    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "categories")
    private List<Goods> goods;


    public Long getId() {
        return id;
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

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public Categories() {

    }

    public Categories(String name, Long parent_id, List<Goods> goods) {
        this.name = name;
        this.parent_id = parent_id;
        this.goods = goods;
    }
}
