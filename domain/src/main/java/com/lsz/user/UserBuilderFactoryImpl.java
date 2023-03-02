package com.lsz.user;

import com.lsz.sequence.SequenceService;
import com.lsz.sequence.SequenceTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserBuilderFactoryImpl
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:41
 * @Version 1.0.0
 **/
@Component
public class UserBuilderFactoryImpl implements UserBuilderFactory {

    @Autowired
    private SequenceService sequenceService;

    @Override
    public UserBuilder builder() {
        String userId = sequenceService.generateUniqueId(SequenceTypeEnum.USER_ID);
        return new UserBuilder(userId);
    }
}
