package com.lsz.user;

import com.lsz.sequence.SequenceService;
import com.lsz.sequence.SequenceTypeEnum;
import com.lsz.valueobject.Day;
import com.lsz.valueobject.Password;
import com.lsz.valueobject.UserId;

import java.util.Date;
import java.util.Random;

/**
 * @ClassName UserBuilder
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:32
 * @Version 1.0.0
 **/
public class UserBuilder {

    private static final long SEED = 10000;

    private static final Random random = new Random(SEED);

    private String userId;

    private String userName;

    private String password;

    private final SequenceService sequenceService;


    private final PasswordService passwordService;

    public UserBuilder(SequenceService sequenceService, PasswordService passwordService) {
        this.sequenceService = sequenceService;
        this.passwordService = passwordService;
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
        user.setUserId(UserId.of(sequenceService.generateUniqueId(SequenceTypeEnum.USER_ID)));
        user.setUserName(userName);
        // 对密码进行编码
        String salt = String.valueOf(random.nextInt());
        String encryptPassword = encrypt(password, salt);
        user.setPassword(Password.of(encryptPassword, salt));

        user.setUserId(UserId.of(userId));
        return user;
    }

    private String encrypt(String password, String salt) {
        return passwordService.encryptPassword(password, salt);
    }



}
