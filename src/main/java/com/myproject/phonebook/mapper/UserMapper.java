package com.myproject.phonebook.mapper;

import com.myproject.phonebook.dto.UserDto;
import com.myproject.phonebook.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto UserDtoFromUser(User user);

    User toUser(UserDto userDto);
}
