package br.com.pcpEquip.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String code;
    private String name;
    private String description;
    private BigDecimal quantity;
    private String brand;
    private String model;
    @Column(name = "BUY_VALUE")
    private BigDecimal buyValue;
    @Column(name = "SELL_VALUE")
    private BigDecimal sellValue;
    @Column(name = "BUY_DATE")
    @Temporal(TemporalType.DATE)
    private Date buyDate;
    private String NCM;
    @ManyToOne
    @JoinColumn(name = "SUPPLIER_CONTACT_FK")
    private ContactGeneral supplier;

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getBuyValue() {
        return buyValue;
    }

    public void setBuyValue(BigDecimal buyValue) {
        this.buyValue = buyValue;
    }

    public BigDecimal getSellValue() {
        return sellValue;
    }

    public void setSellValue(BigDecimal sellValue) {
        this.sellValue = sellValue;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public String getNCM() {
        return NCM;
    }

    public void setNCM(String NCM) {
        this.NCM = NCM;
    }

    public ContactGeneral getSupplier() {
        return supplier;
    }

    public void setSupplier(ContactGeneral supplier) {
        this.supplier = supplier;
    }
}
