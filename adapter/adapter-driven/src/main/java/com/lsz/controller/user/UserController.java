package com.lsz.controller.user;

import com.lsz.user.RegisterUserDto;
import com.lsz.user.UserDto;
import com.lsz.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:02
 * @Version 1.0.0
 **/
@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    public RegisterUserDto registerUser(RegisterUserRequest request) {
        return userService.registerUser(UserCommandAssembler.INSTANCE.toRegisterUserCommand(request));
    }

    @GetMapping("/queryUser/{userId}")
    public UserDto queryUser(@PathVariable("userId") String userId) {
        System.out.println("userId = " + userId);
        UserDto userDto = userService.queryUser(userId);
        System.out.println("userDto = " + userDto);
        return userDto;
    }


}
