package productentity;

import javax.persistence.*;
import java.util.ArrayList;

import java.util.List;


@Entity
public class Catergory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    protected String name;
    @OneToMany(cascade =  CascadeType.ALL,targetEntity = Product.class)
    private List<Product> products = new ArrayList<>();

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
