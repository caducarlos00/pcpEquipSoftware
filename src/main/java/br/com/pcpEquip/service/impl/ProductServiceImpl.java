package br.com.pcpEquip.service.impl;

import br.com.pcpEquip.entity.ContactGeneral;
import br.com.pcpEquip.entity.Product;
import br.com.pcpEquip.repository.ProductRepository;
import br.com.pcpEquip.service.ContactGeneralService;
import br.com.pcpEquip.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Autowired
    private ContactGeneralService contactGeneralService;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        if (contactGeneralService.findByName(product.getSupplier().getName()) != null) {
            product.setSupplier(contactGeneralService.findByName(product.getSupplier().getName()));
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow(NoSuchElementException::new);
        product.setCode(productDetails.getCode());
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setQuantity(productDetails.getQuantity());
        product.setBrand(productDetails.getBrand());
        product.setModel(productDetails.getModel());
        product.setPurchaseValue(productDetails.getPurchaseValue());
        product.setSellValue(productDetails.getSellValue());
        product.setPurchaseDate(productDetails.getPurchaseDate());
        if (productDetails.getSupplier() != null && productDetails.getSupplier().getName() != null) {
            ContactGeneral supplier = contactGeneralService.findByName(productDetails.getSupplier().getName());
            if (supplier != null) {
                product.setSupplier(supplier);
            } else {
                product.setSupplier(productDetails.getSupplier());
            }
        }
        product.setCategory(productDetails.getCategory());
        return productRepository.save(product);
    }

    @Override
    public Product updateProductPartially(Long id, Map<String, Object> updates) {
        Product product = productRepository.findById(id).orElseThrow(NoSuchElementException::new);

        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Product.class, key);
            if (field != null) {
                field.setAccessible(true);
                if ("supplier".equals(key) && value instanceof Map<?, ?> supplierMap) {
                    Object name = supplierMap.get("name");
                    if (name instanceof String supplierName) {
                        ContactGeneral supplier = contactGeneralService.findByName(supplierName);
                        if (supplier != null) {
                            product.setSupplier(supplier);
                        }
                    }
                } else {
                    ReflectionUtils.setField(field, product, value);
                }
            }
        });
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
    }

    /**
     * @param name
     * @return
     */
    @Override
    public Product getProductByName(String name) {
        return productRepository.findOneByNameContains(name);
    }
}
