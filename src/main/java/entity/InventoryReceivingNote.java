package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "Inventory Receiving Note")
public class InventoryReceivingNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "providerOrder")
    private ProviderOrder providerOrder;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff")
    private Staff staff;

    public InventoryReceivingNote() {
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

    public ProviderOrder getProviderOrder() {
        return providerOrder;
    }

    public void setProviderOrder(ProviderOrder providerOrder) {
        this.providerOrder = providerOrder;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
