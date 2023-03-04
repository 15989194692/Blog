package com.lsz.blog.builder;

import com.lsz.blog.domain.Blog;
import com.lsz.blog.enums.BlogStatusEnum;
import com.lsz.framework.sequence.SequenceService;
import com.lsz.framework.sequence.SequenceTypeEnum;
import com.lsz.framework.valueobject.Day;
import com.lsz.framework.valueobject.UserId;

import java.util.Date;
import java.util.Objects;

/**
 * @ClassName BlogBuilder
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/3 上午8:43
 * @Version 1.0.0
 **/
public class BlogBuilder {
    private String blogTitle;

    private String blogContent;

    private String status;

    private String userId;


    private final SequenceService sequenceService;


    BlogBuilder(SequenceService sequenceService) {
        this.sequenceService = sequenceService;
    }


    public BlogBuilder blogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
        return this;
    }


    public BlogBuilder blogContent(String blogContent) {
        this.blogContent = blogContent;
        return this;
    }


    public BlogBuilder status(String status) {
        this.status = status;
        return this;
    }

    public BlogBuilder userId(String userId) {
        this.userId = userId;
        return this;
    }

    public Blog build() {
        Date now = new Date();
        Blog blog = new Blog(UserId.of(userId), Day.of(now), Day.of(now));
        blog.setBlogId(sequenceService.generateUniqueId(SequenceTypeEnum.BLOG_ID));
        blog.setBlogTitle(blogTitle);
        blog.setBlogContent(blogContent);
        if (Objects.nonNull(status)) {
            blog.setStatus(BlogStatusEnum.valueOf(status));
        }
        return blog;
    }

}
