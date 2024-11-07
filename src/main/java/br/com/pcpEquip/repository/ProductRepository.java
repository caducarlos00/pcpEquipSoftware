package br.com.pcpEquip.repository;

import br.com.pcpEquip.domain.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findOneByNameContains(String name);
}
