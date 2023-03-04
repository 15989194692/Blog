package com.lsz.user;

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
