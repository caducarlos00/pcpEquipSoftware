package br.com.pcpEquip.service;

import br.com.pcpEquip.entity.ContactGeneral;

import java.util.List;
import java.util.Map;

public interface ContactGeneralService {

    ContactGeneral getContactGeneralById(Long id);

    List<ContactGeneral> getAllContactGeneral();

    ContactGeneral createContactGeneral(ContactGeneral contactGeneral);

    ContactGeneral updateContactGeneral(Long id, ContactGeneral contactGeneral);

    ContactGeneral updateContactGeneralPartially(Long id, Map<String, Object> updates);

    ContactGeneral findByName(String name);

    void deleteContactGeneral(Long id);
}
