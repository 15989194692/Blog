package com.lsz.user;

import com.lsz.user.command.RegisterUserCommand;
import com.lsz.user.command.UserLoginCommand;
import com.lsz.user.dto.RegisterUserDto;
import com.lsz.user.dto.UserDto;
import com.lsz.user.dto.UserLoginDto;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:00
 * @Version 1.0.0
 **/
public interface UserService {


    RegisterUserDto registerUser(RegisterUserCommand registerUserCommand);


    UserLoginDto login(UserLoginCommand command);


    UserDto queryUser(String userId);

}
