package com.myproject.phonebook.controller;

import com.myproject.phonebook.dto.AuthenticationRequestDto;
import com.myproject.phonebook.dto.RegistrationUserDto;
import com.myproject.phonebook.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/start")
@RequiredArgsConstructor
public class LoginController {

    private final UserServiceImpl userService;

    @GetMapping("/login")
    public String startLogin(@ModelAttribute("user") AuthenticationRequestDto userDto) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") AuthenticationRequestDto userDto) {
        return "redirect:/users";
    }

    @GetMapping("/register")
    public String startRegistration(@ModelAttribute("user") RegistrationUserDto userDto) {
        return "registration";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") RegistrationUserDto registrationUserDto) {
        userService.save(registrationUserDto);
        return "redirect:/users";
    }
}
