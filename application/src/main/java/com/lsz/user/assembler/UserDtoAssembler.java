package com.lsz.user.assembler;

import com.lsz.user.User;
import com.lsz.user.dto.RegisterUserDto;
import com.lsz.user.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @ClassName UserDtoAssembler
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:47
 * @Version 1.0.0
 **/
@Mapper
public interface UserDtoAssembler {

    UserDtoAssembler INSTANCE = Mappers.getMapper(UserDtoAssembler.class);

    RegisterUserDto toRegisterUserDto(User user);

    @Mapping(target = "userId", source = "user.userId.id")
    UserDto toUserDto(User user);

}
