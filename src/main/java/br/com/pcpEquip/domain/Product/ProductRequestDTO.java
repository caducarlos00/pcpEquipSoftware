package br.com.pcpEquip.domain.Product;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ProductRequestDTO {
    private Long productId;
    private String productName;
    private int quantity;

}