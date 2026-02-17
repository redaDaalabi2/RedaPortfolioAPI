package com.imm.redaportfolioapi.mapper;

import com.imm.redaportfolioapi.dto.ContactDTO;
import com.imm.redaportfolioapi.model.Contact;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    ContactDTO toContactDTO(Contact contact);

    Contact toContact(ContactDTO contactDTO);

    List<ContactDTO> toContactDTOList(List<Contact> contacts);

    List<Contact> toContactList(List<ContactDTO> contactDTOS);
}
