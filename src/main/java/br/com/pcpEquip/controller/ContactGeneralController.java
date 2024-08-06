package br.com.pcpEquip.controller;

import br.com.pcpEquip.model.ContactGeneral;
import br.com.pcpEquip.service.ContactGeneralService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/contactGeneral")
public class ContactGeneralController {

    private final ContactGeneralService contactGeneralService;

    public ContactGeneralController(ContactGeneralService contactGeneralService) {
        this.contactGeneralService = contactGeneralService;
    }

    @GetMapping
    public List<ContactGeneral> getAllContactGeneral() {
        return contactGeneralService.getAllContactGeneral();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactGeneral> getContactGeneralById(@PathVariable Long id) {
        var contactGeneral = contactGeneralService.getContactGeneralById(id);
        return ResponseEntity.ok(contactGeneral);
    }

    @PostMapping
    public ResponseEntity<ContactGeneral> createContactGeneral(@RequestBody ContactGeneral contactGeneral) {
        contactGeneralService.createContactGeneral(contactGeneral);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(contactGeneral.getId())
                .toUri();
        return ResponseEntity.created(location).body(contactGeneral);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactGeneral> updateContactGeneral(@PathVariable Long id, @RequestBody ContactGeneral contactGeneralDetails) {
        contactGeneralService.updateContactGeneral(id, contactGeneralDetails);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(contactGeneralDetails.getId())
                .toUri();
        return ResponseEntity.created(location).body(contactGeneralDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContactGeneral(@PathVariable Long id){
        contactGeneralService.deleteContactGeneral(id);
        return ResponseEntity.ok().build();
    }
}
