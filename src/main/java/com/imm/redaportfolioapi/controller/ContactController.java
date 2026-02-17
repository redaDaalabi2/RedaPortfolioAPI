package com.imm.redaportfolioapi.controller;

import com.imm.redaportfolioapi.dto.ContactDTO;
import com.imm.redaportfolioapi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    // Créer un nouveau contact à partir d'un ContactDTO
    @PostMapping
    public ContactDTO createContact(@RequestBody ContactDTO contactDTO) {
        return contactService.createContact(contactDTO);
    }

}
