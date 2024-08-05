package br.com.pcpEquip.service.impl;

import br.com.pcpEquip.repository.ContactGeneralRepository;
import br.com.pcpEquip.service.ContactGeneralService;
import org.springframework.stereotype.Service;

@Service
public class ContactGeneralServiceImpl implements ContactGeneralService {

    private final ContactGeneralRepository contactGeneralRepository;

    public ContactGeneralServiceImpl(ContactGeneralRepository contactGeneralRepository){
        this.contactGeneralRepository = contactGeneralRepository;
    }

}
