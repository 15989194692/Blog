package com.lsz.user;

import com.lsz.user.assembler.UserDtoAssembler;
import com.lsz.user.command.RegisterUserCommand;
import com.lsz.user.command.UserLoginCommand;
import com.lsz.user.dto.RegisterUserDto;
import com.lsz.user.dto.UserDto;
import com.lsz.user.dto.UserLoginDto;
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

    @Autowired
    private PasswordService passwordService;

    public RegisterUserDto registerUser(RegisterUserCommand registerUserCommand) {
        User user = userBuilderFactory.builder()
                .userName(registerUserCommand.getUserName())
                .password(registerUserCommand.getUserPassword())
                .build();
        userRepository.save(user);
        return UserDtoAssembler.INSTANCE.toRegisterUserDto(user);
    }

    @Override
    public UserLoginDto login(UserLoginCommand command) {
        User user = userRepository.queryById(command.getUserId());
        passwordService.checkPassword(command.getPassword(), user);
        return null;
    }

    @Override
    public UserDto queryUser(String userId) {
        User user = userRepository.queryById(userId);
        UserDto userDto = new UserDto();
        userDto.setUserName(user.getUserName());
        userDto.setUserId(user.getUserId().getId());
        return UserDtoAssembler.INSTANCE.toUserDto(user);
    }

}
