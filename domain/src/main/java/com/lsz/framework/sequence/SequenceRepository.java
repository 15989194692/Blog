package com.lsz.framework.sequence;

/**
 * @ClassName SequenceRepository
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:59
 * @Version 1.0.0
 **/
public interface SequenceRepository {

    String nextSequenceId(String type);

}
