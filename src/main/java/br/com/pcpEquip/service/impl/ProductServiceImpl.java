package br.com.pcpEquip.service.impl;

import br.com.pcpEquip.entity.Product;
import br.com.pcpEquip.repository.ProductRepository;
import br.com.pcpEquip.service.ContactGeneralService;
import br.com.pcpEquip.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        if (contactGeneralService.findByName(product.getSupplier().getName()) != null) {
            product.setSupplier(contactGeneralService.findByName(product.getSupplier().getName()));
        } else {
            product.setSupplier(productDetails.getSupplier());
        }
        product.setCategory(productDetails.getCategory());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
        }
    }
}
