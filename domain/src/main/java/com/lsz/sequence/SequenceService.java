package com.lsz.sequence;

/**
 * @ClassName SequenceService
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:42
 * @Version 1.0.0
 **/
public interface SequenceService {
    String generateUniqueId(SequenceTypeEnum sequenceType);

}
