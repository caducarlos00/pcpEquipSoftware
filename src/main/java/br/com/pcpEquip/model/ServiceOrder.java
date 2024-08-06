package br.com.pcpEquip.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Date entryDate;
    private Date exitDate;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private ContactGeneral client;

    @ManyToMany
    @JoinTable(
            name = "service_order_product",
            joinColumns = @JoinColumn(name = "service_order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productsUsed;
    private String serviceDescription;
    private String status;
    private double totalPrice;

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

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public ContactGeneral getClient() {
        return client;
    }

    public void setClient(ContactGeneral client) {
        this.client = client;
    }

    public List<Product> getProductsUsed() {
        return productsUsed;
    }

    public void setProductsUsed(List<Product> productsUsed) {
        this.productsUsed = productsUsed;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
