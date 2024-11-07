package br.com.pcpEquip.service.impl;

import br.com.pcpEquip.dto.ProductRequest;
import br.com.pcpEquip.dto.PurchaseOrderRequest;
import br.com.pcpEquip.entity.ContactGeneral;
import br.com.pcpEquip.entity.Product;
import br.com.pcpEquip.entity.PurchaseOrder;
import br.com.pcpEquip.repository.PurchaseOrderRepository;
import br.com.pcpEquip.service.ContactGeneralService;
import br.com.pcpEquip.service.ProductService;
import br.com.pcpEquip.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    @Autowired
    private ContactGeneralService contactGeneralService;
    @Autowired
    private ProductService productService;

    /**
     * @param id
     * @return
     */
    @Override
    public PurchaseOrder getPurchaseOrderById(Long id) {
        return purchaseOrderRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    /**
     * @return
     */
    @Override
    public List<PurchaseOrder> getAllPurchaseOrder() {
        return purchaseOrderRepository.findAll();
    }

    /**
     * @param purchaseOrder
     * @return
     */
    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {
        if (contactGeneralService.findByName(purchaseOrder.getSupplier().getName()) != null) {
            purchaseOrder.setSupplier(contactGeneralService.findByName(purchaseOrder.getSupplier().getName()));
        }
        return purchaseOrderRepository.save(purchaseOrder);
    }

    /**
     * @param request
     * @return
     */
    @Override
    public PurchaseOrder createPurchaseOrderRequest(PurchaseOrderRequest request) {
        PurchaseOrder order = new PurchaseOrder();
        order.setCode(request.getCode());
        order.setDate(request.getDate());
        order.setStatus(request.getStatus());

        // Busca o fornecedor pelo ID
        ContactGeneral supplier = contactGeneralService.findByName(request.getSupplierName());
        order.setSupplier(supplier);

        // Processa os produtos
        List<Product> productsPurchased = new ArrayList<>();
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (ProductRequest productRequest : request.getProducts()) {
            Product product = null;
            if (productRequest.getProductId() != null) {
                product = productService.getProductById(productRequest.getProductId());
            } else if (productRequest.getProductName() != null) {
                product = productService.getProductByName(productRequest.getProductName());
            }
            if (product != null) {
                productsPurchased.add(product);
                totalPrice.add(product.getSellValue().multiply(BigDecimal.valueOf(productRequest.getQuantity())));
            }
        }

        order.setProductsPurchased(productsPurchased);
        order.setTotalPrice(totalPrice);

        return purchaseOrderRepository.save(order);
    }

    /**
     * @param id
     * @param purchaseOrder
     * @return
     */
    @Override
    public PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder purchaseOrder) {
        return null;
    }

    /**
     * @param id
     * @param update
     * @return
     */
    @Override
    public PurchaseOrder updatePurchaseOrderPartially(Long id, Map<String, Object> update) {
        PurchaseOrder order = purchaseOrderRepository.findById(id).orElseThrow(NoSuchElementException::new);

        update.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(PurchaseOrder.class, key);
            if (field != null) {
                field.setAccessible(true);
                if ("supplier".equals(key) && value instanceof Map<?, ?> supplierMap) {
                    Object name = supplierMap.get("name");
                    if (name instanceof String supplierName) {
                        ContactGeneral supplier = contactGeneralService.findByName(supplierName);
                        if (supplier != null) {
                            order.setSupplier(supplier);
                        }
                    }
                } else {
                    ReflectionUtils.setField(field, order, value);
                }
            }
        });

        return purchaseOrderRepository.save(order);
    }

    /**
     * @param id
     */
    @Override
    public void deletePurchaseOrder(Long id) {
        if (purchaseOrderRepository.existsById(id)) {
            purchaseOrderRepository.deleteById(id);
        }
    }
}
