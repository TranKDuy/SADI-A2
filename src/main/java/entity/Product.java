package entity;
import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    protected String name;
    @Column
    protected String model;
    @Column
    protected String brand;
    @Column
    protected String company;
    @Column
    public String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catergory")
    private Catergory catergory;

    public Product() {
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Catergory getCatergory() {
        return catergory;
    }

    public void setCatergory(Catergory catergory) {
        this.catergory = catergory;
    }
}
