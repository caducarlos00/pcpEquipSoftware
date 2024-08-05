package br.com.pcpEquip;

import br.com.pcpEquip.repository.ProductRepository;
import br.com.pcpEquip.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApp implements CommandLineRunner {

    @Autowired
    private ProductRepository repository;


    @Override
    public void run(String... args) throws Exception {
        insertProduct();
    }

    private void insertProduct() {
        Product product = new Product();
        product.setName("TESTE");
        repository.save(product);
    }
}
