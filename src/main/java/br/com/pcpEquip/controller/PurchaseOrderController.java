package br.com.pcpEquip.controller;

import br.com.pcpEquip.dto.GeneralResponse;
import br.com.pcpEquip.dto.PurchaseOrderRequest;
import br.com.pcpEquip.entity.PurchaseOrder;
import br.com.pcpEquip.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/purchaseOrder")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;
    @Autowired
    private GeneralResponse generalResponse;

    //Método para Listar as ordens de compra
    @GetMapping
    public List<PurchaseOrder> getAllPurchaseOrder() {
        return purchaseOrderService.getAllPurchaseOrder();
    }

    //Método para listar uma única ordem de compra pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> getPurchaseOrderById(@PathVariable Long id) {
        var purchaseOrder = purchaseOrderService.getPurchaseOrderById(id);
        return ResponseEntity.ok(purchaseOrder);
    }

    //Método para Cadastrar uma nova ordem de compra
    @PostMapping
    public ResponseEntity<PurchaseOrder> createPurchaseOrder(@RequestBody PurchaseOrderRequest request) {
        PurchaseOrder order = purchaseOrderService.createPurchaseOrderRequest(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrder> updatePurchaseOrder(@PathVariable Long id, @RequestBody PurchaseOrder purchaseOrder) {
        purchaseOrderService.createPurchaseOrder(purchaseOrder);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(purchaseOrder.getId())
                .toUri();

        return ResponseEntity.created(location).body(purchaseOrder);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PurchaseOrder> updatePurchaseOrderPartially(@PathVariable Long id, @RequestBody Map<String, Object> update) {
        PurchaseOrder updatePurchase = purchaseOrderService.updatePurchaseOrderPartially(id, update);
        return ResponseEntity.ok(updatePurchase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePurchaseOrder(@PathVariable Long id) {
        purchaseOrderService.deletePurchaseOrder(id);
        return ResponseEntity.ok().build();
    }
}
