package br.com.pcpEquip.repository;

import br.com.pcpEquip.domain.ServiceOrder.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {
}
