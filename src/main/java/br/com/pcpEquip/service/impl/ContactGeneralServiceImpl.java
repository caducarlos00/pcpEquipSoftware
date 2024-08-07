package br.com.pcpEquip.service.impl;

import br.com.pcpEquip.entity.ContactGeneral;
import br.com.pcpEquip.repository.ContactGeneralRepository;
import br.com.pcpEquip.service.ContactGeneralService;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class ContactGeneralServiceImpl implements ContactGeneralService {

    private final ContactGeneralRepository contactGeneralRepository;

    public ContactGeneralServiceImpl(ContactGeneralRepository contactGeneralRepository) {
        this.contactGeneralRepository = contactGeneralRepository;
    }

    @Override
    public ContactGeneral getContactGeneralById(Long id) {
        return contactGeneralRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<ContactGeneral> getAllContactGeneral() {
        return contactGeneralRepository.findAll();
    }

    @Override
    public ContactGeneral createContactGeneral(ContactGeneral contactGeneral) {
        return contactGeneralRepository.save(contactGeneral);
    }

    @Override
    public ContactGeneral updateContactGeneral(Long id, ContactGeneral contactGeneralDetails) {
        ContactGeneral contactUpdated = contactGeneralRepository.findById(id).orElseThrow(NoSuchElementException::new);
        contactUpdated.setAddress(contactGeneralDetails.getAddress());
        contactUpdated.setEmail(contactGeneralDetails.getEmail());
        contactUpdated.setName(contactGeneralDetails.getName());
        contactUpdated.setType(contactGeneralDetails.getType());
        contactUpdated.setFederalRegistration(contactGeneralDetails.getFederalRegistration());
        contactUpdated.setPhone(contactGeneralDetails.getPhone());
        return contactGeneralRepository.save(contactUpdated);
    }

    @Override
    public ContactGeneral updateContactGeneralPartially(Long id, Map<String, Object> updates) {
        ContactGeneral contact = contactGeneralRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);

        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(ContactGeneral.class, key);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, contact, value);
            }
        });

        return contactGeneralRepository.save(contact);
    }

    @Override
    public ContactGeneral findByName(String name) {
        return contactGeneralRepository.findOneByNameContains(name);
    }

    @Override
    public void deleteContactGeneral(Long id) {
        if (contactGeneralRepository.findById(id).isPresent()){
            contactGeneralRepository.deleteById(id);
        }
    }
}
