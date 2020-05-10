package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import service.InventoryDeliveryService;

import javax.persistence.*;

@Entity
@Table(name ="Staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private int phone;
    @Column
    private String email;

    @OneToOne (mappedBy = "staff",cascade = CascadeType.ALL)
    @JsonIgnore
    private InventoryReceivingNote inventoryReceivingNote;

    @OneToOne (mappedBy = "staff",cascade = CascadeType.ALL)
    @JsonIgnore
    private InventoryDeliveryNote inventoryDeliveryNote;

    @OneToOne (mappedBy = "staff",cascade = CascadeType.ALL)
    @JsonIgnore
    private SalesInvoice salesInvoice;
    public Staff() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InventoryReceivingNote getInventoryReceivingNote() {
        return inventoryReceivingNote;
    }

    public void setInventoryReceivingNote(InventoryReceivingNote inventoryReceivingNote) {
        this.inventoryReceivingNote = inventoryReceivingNote;
    }

    public InventoryDeliveryNote getInventoryDeliveryNote() {
        return inventoryDeliveryNote;
    }

    public void setInventoryDeliveryNote(InventoryDeliveryNote inventoryDeliveryNote) {
        this.inventoryDeliveryNote = inventoryDeliveryNote;
    }

    public SalesInvoice getSalesInvoice() {
        return salesInvoice;
    }

    public void setSalesInvoice(SalesInvoice salesInvoice) {
        this.salesInvoice = salesInvoice;
    }
}
