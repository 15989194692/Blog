package com.lsz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:18
 * @Version 1.0.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserBuilderFactory userBuilderFactory;

    public RegisterUserDto registerUser(RegisterUserCommand registerUserCommand) {
        User user = userBuilderFactory.builder()
                .userName(registerUserCommand.getUserName())
                .password(registerUserCommand.getUserPassword())
                .build();
        userRepository.save(user);
        return UserDtoAssembler.INSTANCE.toRegisterUserDto(user);
    }
}
