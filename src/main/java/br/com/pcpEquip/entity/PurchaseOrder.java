package br.com.pcpEquip.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PURCHASE_ORDER")
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "SUPPLIER_FK")
    private ContactGeneral supplier;

    @ManyToMany
    @JoinTable(
            name = "purchase_order_product",
            joinColumns = @JoinColumn(name = "purchase_order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productsPurchased;
    private int quantity;
    private double totalPrice;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ContactGeneral getSupplier() {
        return supplier;
    }

    public void setSupplier(ContactGeneral supplier) {
        this.supplier = supplier;
    }

    public List<Product> getProductsPurchased() {
        return productsPurchased;
    }

    public void setProductsPurchased(List<Product> productsPurchased) {
        this.productsPurchased = productsPurchased;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
