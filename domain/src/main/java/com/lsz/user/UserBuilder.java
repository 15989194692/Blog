package com.lsz.user;

import com.lsz.valueobject.Day;
import com.lsz.valueobject.Password;
import com.lsz.valueobject.UserId;

import java.util.Date;

/**
 * @ClassName UserBuilder
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:32
 * @Version 1.0.0
 **/
public class UserBuilder {

    private final String userId;

    private String userName;

    private String password;

    public UserBuilder(String userId) {
        this.userId = userId;
    }

    public UserBuilder userName(String userName) {
        this.userName = userName;
        return this;
    }


    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    public User build() {
        Date now = new Date();
        User user = new User(Day.of(now), Day.of(now));
        user.setUserName(userName);
        // 对密码进行编码
        user.setPassword(Password.of(password));
        user.setUserId(UserId.of(userId));
        return user;
    }

}
