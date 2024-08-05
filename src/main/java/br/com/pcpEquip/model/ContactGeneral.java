package br.com.pcpEquip.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Entity
@Table(name = "CONTACT_GENERAL")
public class ContactGeneral {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(name = "FEDERAL_REGISTRATION")
    private String federalRegistration;
    private String phone;
    private String email;
    @Column(name = "IS_SUPPLIER")
    private Boolean isSupplier;

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFederalRegistration() {
        return federalRegistration;
    }

    public void setFederalRegistration(String federalRegistration) {
        this.federalRegistration = federalRegistration;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsSupplier() {
        return isSupplier;
    }

    public void setIsSupplier(Boolean isSupplier) {
        this.isSupplier = isSupplier;
    }
}
