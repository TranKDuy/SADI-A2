package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "ProviderOrder")
public class ProviderOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Product product;

    @Column
    private int quantity;

    @Column
    private int price;

    @OneToOne(mappedBy = "providerOrder",cascade = CascadeType.ALL)
    @JsonIgnore
    private InventoryReceivingNote inventoryReceivingNote;
    @OneToOne(mappedBy = "providerOrder",cascade = CascadeType.ALL)
    @JsonIgnore
    private InventoryDeliveryNote inventoryDeliveryNote;

    public ProviderOrder() {
    }

    public Product getProduct() {
     return product;
 }

   public void setProduct(Product product) {
     this.product = product;
  }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
