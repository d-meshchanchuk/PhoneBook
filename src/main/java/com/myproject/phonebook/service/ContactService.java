package com.myproject.phonebook.service;

import com.myproject.phonebook.dto.ContactDto;
import com.myproject.phonebook.dto.UserDto;

import java.util.List;

public interface ContactService {

    List<ContactDto> findAll();

    ContactDto findById(Long id) throws Exception;

    void save(ContactDto contactDto);

    void delete(Long id);

}
