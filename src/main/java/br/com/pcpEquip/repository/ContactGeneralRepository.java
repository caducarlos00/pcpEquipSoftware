package br.com.pcpEquip.repository;

import br.com.pcpEquip.model.ContactGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactGeneralRepository extends JpaRepository<ContactGeneral, Integer> {
}
