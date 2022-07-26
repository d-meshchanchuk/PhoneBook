package com.myproject.phonebook.service;

import com.myproject.phonebook.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findByUsername(String username);

    UserDto findById(Long id) throws Exception;

    void save(UserDto userDto);

    void delete(Long id);
}
