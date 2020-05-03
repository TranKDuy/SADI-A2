package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;

import java.util.List;


@Entity
public class Catergory {
    @Id
    @Column
    private int id;
    @Column
    protected String name;

    @OneToMany(mappedBy = "catergory",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> products;
    public Catergory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
