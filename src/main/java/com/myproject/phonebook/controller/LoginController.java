package com.myproject.phonebook.controller;

import com.myproject.phonebook.dto.UserDto;
import com.myproject.phonebook.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class LoginController {

    private final UserServiceImpl userService;

    @GetMapping()
    public String startLogin(@ModelAttribute("user") UserDto userDto) {
        return "login";
    }

    @PostMapping()
    public String login(@ModelAttribute("user") UserDto userDto) {
        return "redirect:/contacts";
    }
}
