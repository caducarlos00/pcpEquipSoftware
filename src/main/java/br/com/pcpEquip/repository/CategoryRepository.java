package br.com.pcpEquip.repository;

import br.com.pcpEquip.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Category findOneByNameContains(String name);

    public Category findOneByCodeContains(String code);
}

