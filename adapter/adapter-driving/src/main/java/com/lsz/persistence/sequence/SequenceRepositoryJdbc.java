package com.lsz.persistence.sequence;

import com.lsz.framework.sequence.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.Assert;

/**
 * @ClassName SequenceRepositoryJdbc
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/3 上午12:01
 * @Version 1.0.0
 **/
@Repository
public class SequenceRepositoryJdbc implements SequenceRepository {

    @Autowired
    private SequenceDoMapper sequenceDoMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public String nextSequenceId(String type) {

        Long sequenceId = transactionTemplate.execute(action -> {
            SequenceDo lock = sequenceDoMapper.lock(type);
            Long nextSequence = lock.getValue();
            int updateCount = sequenceDoMapper.increateValue(lock);
            Assert.isTrue(updateCount == 1, "update sequence failed");
            return nextSequence;
        });
        return String.valueOf(sequenceId);
    }
}
