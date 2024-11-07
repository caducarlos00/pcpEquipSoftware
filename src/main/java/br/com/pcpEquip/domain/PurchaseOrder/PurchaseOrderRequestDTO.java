package br.com.pcpEquip.domain.PurchaseOrder;

import br.com.pcpEquip.domain.Product.ProductRequestDTO;

import java.util.Date;
import java.util.List;

public record PurchaseOrderRequestDTO(String code, Date date, String supplierName, List<ProductRequestDTO> products,
                                      String status) {
}
