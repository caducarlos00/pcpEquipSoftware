package br.com.pcpEquip.service;

import br.com.pcpEquip.model.ContactGeneral;

import java.util.List;

public interface ContactGeneralService {

    ContactGeneral getContactGeneralById(Long id);

    List<ContactGeneral> getAllContactGeneral();

    ContactGeneral createContactGeneral(ContactGeneral contactGeneral);

    ContactGeneral updateContactGeneral(Long id, ContactGeneral contactGeneral);

    ContactGeneral findByName(String name);

    void deleteContactGeneral(Long id);
}
