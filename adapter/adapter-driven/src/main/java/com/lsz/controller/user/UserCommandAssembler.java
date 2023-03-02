package com.lsz.controller.user;

import com.lsz.user.RegisterUserCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @ClassName UserCommandAssembler
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/3 上午12:09
 * @Version 1.0.0
 **/
@Mapper
public interface UserCommandAssembler {

    UserCommandAssembler INSTANCE = Mappers.getMapper(UserCommandAssembler.class);

    RegisterUserCommand toRegisterUserCommand(RegisterUserRequest request);


}
