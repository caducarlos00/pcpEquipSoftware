package br.com.pcpEquip.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Entity
@Table(name = "CONTACT_GENERAL")
public class ContactGeneral {

    private Integer id;
    private String name;
    private String federalRegistration;
    private String phone;
    private String email;
    private Boolean isSupplier;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "FEDERAL_REGISTRATION")
    public String getFederalRegistration() {
        return federalRegistration;
    }

    public void setFederalRegistration(String federalRegistration) {
        this.federalRegistration = federalRegistration;
    }

    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "IS_SUPPLIER")
    public Boolean getIsSupplier() {
        return isSupplier;
    }

    public void setIsSupplier(Boolean isSupplier) {
        this.isSupplier = isSupplier;
    }
}
