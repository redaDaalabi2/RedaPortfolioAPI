package com.imm.redaportfolioapi.service;

import com.imm.redaportfolioapi.dto.ContactDTO;
import com.imm.redaportfolioapi.mapper.ContactMapper;
import com.imm.redaportfolioapi.model.Contact;
import com.imm.redaportfolioapi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactMapper contactMapper;

    // Enregistrer un nouveau Contact en utilisant un DTO
    public ContactDTO saveContact(ContactDTO contactDTO) {
        Contact contact = contactMapper.toContact(contactDTO);
        contact = contactRepository.save(contact);
        return contactMapper.toContactDTO(contact);
    }

    // Créer un nouveau Contact à partir d'un DTO
    public ContactDTO createContact(ContactDTO contactDTO) {
        Contact contact = contactMapper.toContact(contactDTO);
        contact.setId(contactDTO.getId());
        contact.setFullName(contactDTO.getFullName());
        contact.setEmail(contactDTO.getEmail());
        contact.setSubject(contactDTO.getSubject());
        contact.setMessage(contactDTO.getMessage());
        contact.setCreatedAt(LocalDateTime.now());
        contact = contactRepository.save(contact);
        return contactMapper.toContactDTO(contact);
    }

}
