package com.myproject.phonebook.mapper;

import com.myproject.phonebook.dto.ContactDto;
import com.myproject.phonebook.model.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    ContactDto ContactDtoFromContact(Contact contact);

    Contact toContact(ContactDto contactDto);
}
