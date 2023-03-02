package com.lsz.sequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SequenceServiceImpl
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/3 上午12:02
 * @Version 1.0.0
 **/
@Service
public class SequenceServiceImpl implements SequenceService {

    @Autowired
    private SequenceRepository sequenceRepository;

    @Override
    public String generateUniqueId(SequenceTypeEnum sequenceType) {
        return sequenceRepository.nextSequenceId(sequenceType.getCode());
    }
}
