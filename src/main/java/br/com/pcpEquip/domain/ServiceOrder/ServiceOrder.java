package br.com.pcpEquip.domain.ServiceOrder;

import br.com.pcpEquip.domain.ContactGeneral.ContactGeneral;
import br.com.pcpEquip.domain.Product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SERVICE_ORDER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
