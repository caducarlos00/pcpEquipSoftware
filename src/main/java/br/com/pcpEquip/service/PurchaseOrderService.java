package br.com.pcpEquip.service;

import br.com.pcpEquip.domain.PurchaseOrder.PurchaseOrderRequestDTO;
import br.com.pcpEquip.domain.PurchaseOrder.PurchaseOrder;

import java.util.List;
import java.util.Map;

public interface PurchaseOrderService {

    PurchaseOrder getPurchaseOrderById(Long id);

    List<PurchaseOrder> getAllPurchaseOrder();

    PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder);

    PurchaseOrder createPurchaseOrderRequest(PurchaseOrderRequestDTO request);

    PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder purchaseOrder);

    PurchaseOrder updatePurchaseOrderPartially(Long id, Map<String, Object> update);

    void deletePurchaseOrder(Long id);
}
