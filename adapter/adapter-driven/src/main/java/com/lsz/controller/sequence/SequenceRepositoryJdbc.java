package com.lsz.controller.sequence;

import com.lsz.sequence.SequenceRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName SequenceRepositoryJdbc
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/3 上午12:01
 * @Version 1.0.0
 **/
@Repository
public class SequenceRepositoryJdbc implements SequenceRepository {


    @Override
    public String nextSequenceId(String type) {

        return null;
    }
}
