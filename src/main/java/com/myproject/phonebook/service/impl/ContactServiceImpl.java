package com.myproject.phonebook.service.impl;

import com.myproject.phonebook.dto.ContactDto;
import com.myproject.phonebook.mapper.ContactMapper;
import com.myproject.phonebook.model.Contact;
import com.myproject.phonebook.repository.ContactRepository;
import com.myproject.phonebook.service.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;


    @Override
    public List<ContactDto> findAll() {
        List<Contact> users = contactRepository.findAll();
        List<ContactDto> result = users.stream().map(contactMapper::ContactDtoFromContact)
                .collect(Collectors.toList());
        log.info("IN findAll - {} contact found", result.size());
        return result;
    }

    @Override
    public ContactDto findById(Long id) throws Exception {
        //todo обработать ExceptionHandler
        Contact contact = contactRepository.findById(id).orElseThrow(Exception::new);
        log.info("IN findById - contact: {} found by id: {}", contact, id);
        return contactMapper.ContactDtoFromContact(contact);
    }

    @Transactional
    @Override
    public void save(ContactDto contactDto) {
        Contact contact = contactMapper.toContact(contactDto);
        contactRepository.save(contact);
        log.info("IN save - contact: {} successfully created", contact);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);
        log.info("IN delete - contact with id: {} successfully deleted", id);
    }
}
