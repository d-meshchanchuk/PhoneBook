package com.myproject.phonebook.service;

import com.myproject.phonebook.dto.RegistrationUserDto;
import com.myproject.phonebook.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findByUsername(String username);

    UserDto findById(Long id) throws Exception;

    void save(RegistrationUserDto registrationUserDto);

    void delete(Long id);
}
