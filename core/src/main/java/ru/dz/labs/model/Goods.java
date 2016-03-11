package ru.dz.labs.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Float price;
    private String image;
    private String description;
    private String company;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Categories categories;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "goods")
    private List<Carts> carts;


    public Goods() {
    }

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public Goods(String name, float price, String image, String description, String company, Categories categories, List<Carts> carts) {

        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
        this.company = company;
        this.categories = categories;
        this.carts = carts;
    }
}
