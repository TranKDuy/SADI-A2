package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;

import java.util.List;


@Entity
public class Catergory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int catergoryid;
    @Column
    protected String catergoryname;

    @OneToMany(mappedBy = "catergory",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> products;
    public Catergory() {
    }

    public int getCatergoryid() {
        return catergoryid;
    }

    public void setCatergoryid(int catergoryid) {
        this.catergoryid = catergoryid;
    }

    public String getCatergoryname() {
        return catergoryname;
    }

    public void setCatergoryname(String catergoryname) {
        this.catergoryname = catergoryname;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
