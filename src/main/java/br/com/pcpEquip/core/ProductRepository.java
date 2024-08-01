package br.com.pcpEquip.core;

import br.com.pcpEquip.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
