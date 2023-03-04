package com.lsz.blog.builder;

import com.lsz.framework.sequence.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName BlogBuilderFactoryImpl
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/3 上午8:51
 * @Version 1.0.0
 **/
@Component
public class BlogBuilderFactoryImpl implements BlogBuilderFactory {

    @Autowired
    private SequenceService sequenceService;

    @Override
    public BlogBuilder builder() {
        return new BlogBuilder(sequenceService);
    }
}
