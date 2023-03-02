package com.lsz.user;

import com.lsz.valueobject.Day;
import com.lsz.valueobject.Password;
import com.lsz.valueobject.UserId;

/**
 * @ClassName User
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:00
 * @Version 1.0.0
 **/
public class User {

    private UserId userId;

    private Password password;

    private String userName;

    private Day gmtCreate;

    private Day gmtModified;

    public User(Day gmtCreate, Day gmtModified) {
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }




    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Day getGmtCreate() {
        return gmtCreate;
    }

    public Day getGmtModified() {
        return gmtModified;
    }
}
