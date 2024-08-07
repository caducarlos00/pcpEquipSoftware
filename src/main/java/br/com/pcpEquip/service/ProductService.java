package br.com.pcpEquip.service;

import br.com.pcpEquip.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    Product updateProductPartially(Long id, Map<String, Object> updates);

    void deleteProduct(Long id);
}
