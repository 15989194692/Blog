package com.lsz.user;

import com.lsz.framework.domain.AggregateRoot;
import com.lsz.framework.valueobject.Day;
import com.lsz.framework.valueobject.Password;
import com.lsz.framework.valueobject.UserId;

/**
 * @ClassName User
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:00
 * @Version 1.0.0
 **/
public class User extends AggregateRoot {

    private UserId userId;

    private Password password;

    private String userName;

    private Day gmtCreate;

    private Day gmtModified;

    public User(Day gmtCreate, Day gmtModified) {
        super(gmtCreate, gmtModified);
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public boolean isSamePassword(String anotherPassword) {
        return password.isSamePassword(anotherPassword);
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
