package br.com.pcpEquip.service;

import br.com.pcpEquip.dto.PurchaseOrderRequest;
import br.com.pcpEquip.entity.PurchaseOrder;

import java.util.List;
import java.util.Map;

public interface PurchaseOrderService {

    PurchaseOrder getPurchaseOrderById(Long id);

    List<PurchaseOrder> getAllPurchaseOrder();

    PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder);

    PurchaseOrder createPurchaseOrderRequest(PurchaseOrderRequest request);

    PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder purchaseOrder);

    PurchaseOrder updatePurchaseOrderPartially(Long id, Map<String, Object> update);

    void deletePurchaseOrder(Long id);
}
