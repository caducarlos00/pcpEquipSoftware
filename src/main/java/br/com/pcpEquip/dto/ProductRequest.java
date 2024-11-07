package br.com.pcpEquip.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ProductRequest {
    private Long productId;
    private String productName;
    private int quantity;

}