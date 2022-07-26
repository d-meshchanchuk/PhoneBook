package com.myproject.phonebook.controller;

import com.myproject.phonebook.dto.ContactDto;
import com.myproject.phonebook.dto.UserDto;
import com.myproject.phonebook.service.ContactService;
import com.myproject.phonebook.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping()
    public String getContacts(Model model) {
        List<ContactDto> contacts = contactService.findAll();
        model.addAttribute("contacts", contacts);
        return "all-contacts";
    }

    @GetMapping("/addContact")
    public String showSaveForm(@ModelAttribute("contact") ContactDto contactDto) {
        return "add-contact";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("contact") ContactDto contactDto) {
        contactService.save(contactDto);
        return "redirect:/contacts";
    }

    @GetMapping (value = "{id}")
    public String delete(@ModelAttribute("contact") ContactDto contactDto, @PathVariable(name = "id") Long id) {
        System.out.println(id);
        contactService.delete(id);
        return "redirect:/contacts";
    }
}
