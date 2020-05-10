package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "salesinvoice")
public class SalesInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String date;

    @Column
    private double totalvalue;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff")
    private Staff staff;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "providerOrder")
    private ProviderOrder providerOrder;


    public SalesInvoice() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalvalue() {
        return totalvalue;
    }

    public void setTotalvalue(double totalvalue) {
        this.totalvalue = totalvalue;
    }

    public ProviderOrder getProviderOrder() {
        return providerOrder;
    }

    public void setProviderOrder(ProviderOrder providerOrder) {
        this.providerOrder = providerOrder;
    }
}
