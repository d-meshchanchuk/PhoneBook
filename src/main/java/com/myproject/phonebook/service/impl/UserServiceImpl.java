package com.myproject.phonebook.service.impl;

import com.myproject.phonebook.dto.RegistrationUserDto;
import com.myproject.phonebook.dto.UserDto;
import com.myproject.phonebook.mapper.UserMapper;
import com.myproject.phonebook.model.Role;
import com.myproject.phonebook.model.Status;
import com.myproject.phonebook.model.User;
import com.myproject.phonebook.repository.RoleRepository;
import com.myproject.phonebook.repository.UserRepository;
import com.myproject.phonebook.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> result = users.stream().map(userMapper::UserDtoFromUser)
                .collect(Collectors.toList());
        log.info("IN getAll - {} users found", result.size());
        return result;
    }

    @Override
    public UserDto findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        UserDto result = userMapper.UserDtoFromUser(user);
        if (result == null) {
            log.warn("IN findByUserName - no user found by username: {}", username);
        }

        log.info("IN findByUsername - user: {} found by username: {}", result, username);
        return result;
    }

    @Override
    public UserDto findById(Long id) throws Exception {
        //обработать ExceptionHandler
        User user = userRepository.findById(id).orElseThrow(Exception::new);
        log.info("IN findById - user: {} found by id: {}", user, id);
        return userMapper.UserDtoFromUser(user);
    }

    @Transactional
    @Override
    public void save(RegistrationUserDto registrationUserDto) {
        //todo выбор картинки и загрузка
        User user = userMapper.toUser(registrationUserDto);

        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleRepository.findByName("ROLE_USER"));

        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        userRepository.save(user);
        log.info("IN save - tariff: {} successfully created", user);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully deleted", id);
    }
}
