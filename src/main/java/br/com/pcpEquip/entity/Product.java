package br.com.pcpEquip.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String description;
    private int quantity;
    private String brand;
    private String model;
    @Column(name = "PURCHASE_VALUE")
    private BigDecimal purchaseValue;
    @Column(name = "SELL_VALUE")
    private BigDecimal sellValue;
    @Column(name = "PURCHASE_DATE")
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    private String NCM;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SUPPLIER_FK")
    private ContactGeneral supplier;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORY_FK")
    private Category category;

}
