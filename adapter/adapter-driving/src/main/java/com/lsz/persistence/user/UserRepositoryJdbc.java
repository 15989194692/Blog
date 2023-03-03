package com.lsz.persistence.user;

import com.lsz.user.User;
import com.lsz.user.UserRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserRepositoryJdbc
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:02
 * @Version 1.0.0
 **/
@Repository
public class UserRepositoryJdbc implements UserRepository {



    public boolean save(User user) {
        UserDo userDo = UserDoConverter.INSTANCE.toDo(user);

        return false;
    }

    @Override
    public User queryById(String userId) {
        return null;
    }
}
