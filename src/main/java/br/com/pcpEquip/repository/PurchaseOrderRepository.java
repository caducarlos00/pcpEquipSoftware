package br.com.pcpEquip.repository;

import br.com.pcpEquip.domain.PurchaseOrder.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Long> {
}
