package com.lsz.blog;

import com.lsz.framework.sequence.SequenceService;
import com.lsz.framework.sequence.SequenceTypeEnum;
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
        String blogId = sequenceService.generateUniqueId(SequenceTypeEnum.BLOG_ID);
        return new BlogBuilder(blogId);
    }
}
