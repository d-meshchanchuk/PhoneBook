package com.myproject.phonebook.mapper;

import com.myproject.phonebook.dto.RegistrationUserDto;
import com.myproject.phonebook.dto.UserDto;
import com.myproject.phonebook.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    RegistrationUserDto RegistrationUserDtoFromUser(User user);

    UserDto UserDtoFromUser(User user);

    User toUser(RegistrationUserDto registrationUserDto);

    User toUser(UserDto userDto);
}
