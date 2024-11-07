package br.com.pcpEquip.repository;

import br.com.pcpEquip.domain.ContactGeneral.ContactGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactGeneralRepository extends JpaRepository<ContactGeneral, Long> {

    ContactGeneral findOneByNameContains(String name);
}
