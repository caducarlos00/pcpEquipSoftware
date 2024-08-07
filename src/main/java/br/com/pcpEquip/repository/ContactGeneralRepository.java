package br.com.pcpEquip.repository;

import br.com.pcpEquip.entity.ContactGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactGeneralRepository extends JpaRepository<ContactGeneral, Long> {

    public ContactGeneral findOneByNameContains(String name);
}
