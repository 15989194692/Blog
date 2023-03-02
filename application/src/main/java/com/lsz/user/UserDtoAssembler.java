package com.lsz.user;

import org.mapstruct.Mapper;
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

}
