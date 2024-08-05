package br.com.pcpEquip.service.impl;

import br.com.pcpEquip.repository.ProductRepository;
import br.com.pcpEquip.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

}
