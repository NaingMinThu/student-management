package com.me.studentmanagement.mapper;

import com.me.studentmanagement.datamodel.User;
import com.me.studentmanagement.dto.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    UserResponse bindDataModelToResponse(User user);
}
