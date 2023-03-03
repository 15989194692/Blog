package com.lsz.user;

/**
 * @ClassName UserRepository
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:01
 * @Version 1.0.0
 **/
public interface UserRepository {

    boolean save(User user);

    User queryById(String userId);

}
