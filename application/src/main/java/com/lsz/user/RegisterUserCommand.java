package com.lsz.user;

/**
 * @ClassName RegisterUserCommand
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:17
 * @Version 1.0.0
 **/
public class RegisterUserCommand {

    private String userName;

    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
