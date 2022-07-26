package com.myproject.phonebook.repository;

import com.myproject.phonebook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
