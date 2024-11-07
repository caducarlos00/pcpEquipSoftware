package br.com.pcpEquip.domain.ContactGeneral;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "CONTACT_GENERAL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactGeneral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "FEDERAL_REGISTRATION")
    private String federalRegistration;
    private String phone;
    private String email;
    private String address;
    private String type; // "Supplier" or "Client"

}
