package com.lsz.persistence.user;

import com.lsz.persistence.AuditableDo;

import java.util.Date;

/**
 * @ClassName UserDo
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/3 上午12:03
 * @Version 1.0.0
 **/
public class UserDo extends AuditableDo {

    private String userId;

    private String password;

    private String userName;

    private String salt;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
