package br.com.pcpEquip.service.impl;

import br.com.pcpEquip.domain.Product.ProductRequestDTO;
import br.com.pcpEquip.domain.PurchaseOrder.PurchaseOrderRequestDTO;
import br.com.pcpEquip.domain.ContactGeneral.ContactGeneral;
import br.com.pcpEquip.domain.Product.Product;
import br.com.pcpEquip.domain.PurchaseOrder.PurchaseOrder;
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
    public PurchaseOrder createPurchaseOrderRequest(PurchaseOrderRequestDTO request) {
        PurchaseOrder order = new PurchaseOrder();
        order.setCode(request.code());
        order.setDate(request.date());
        order.setStatus(request.status());

        // Busca o fornecedor pelo ID
        ContactGeneral supplier = contactGeneralService.findByName(request.supplierName());
        order.setSupplier(supplier);

        // Processa os produtos
        List<Product> productsPurchased = new ArrayList<>();
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (ProductRequestDTO productRequestDTO : request.products()) {
            Product product = null;
            if (productRequestDTO.getProductId() != null) {
                product = productService.getProductById(productRequestDTO.getProductId());
            } else if (productRequestDTO.getProductName() != null) {
                product = productService.getProductByName(productRequestDTO.getProductName());
            }
            if (product != null) {
                productsPurchased.add(product);
                totalPrice.add(product.getSellValue().multiply(BigDecimal.valueOf(productRequestDTO.getQuantity())));
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
