package br.com.pcpEquip.domain.PurchaseOrder;

import br.com.pcpEquip.domain.ContactGeneral.ContactGeneral;
import br.com.pcpEquip.domain.Product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PURCHASE_ORDER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private BigDecimal totalPrice;
    private String status;

}
