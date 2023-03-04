package com.lsz.persistence.blog;

import com.lsz.blog.domain.Blog;
import com.lsz.blog.BlogRepository;
import com.lsz.blog.query.BlogQuery;
import com.lsz.persistence.blog.converter.BlogDoConverter;
import com.lsz.persistence.blog.dataobject.BlogDo;
import com.lsz.persistence.blog.mappers.BlogDoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ClassName BlogRepositoryJdbc
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/3 上午8:37
 * @Version 1.0.0
 **/
@Repository
public class BlogRepositoryJdbc implements BlogRepository {

    @Autowired
    private BlogDoMapper blogDoMapper;

    @Override
    public boolean save(Blog blog) {
        BlogDo blogDo = toDo(blog);
        if (blog.isNew()) {
            return blogDoMapper.insert(blogDo) == 1;
        } else if (blog.isUpdate()) {
            return blogDoMapper.updateByPrimaryKey(blogDo) == 1;
        }
        Assert.isTrue(blog.isUnChange(), "blog operate status unexpected, blog: " + blog);
        return true;
    }

    @Override
    public Blog queryById(String blogId) {
        BlogDo blogDo = blogDoMapper.selectByBlogId(blogId);
        return toEntity(blogDo);
    }

    @Override
    public List<Blog> query(BlogQuery query) {
        List<BlogDo> blogDoList = blogDoMapper.selectByCondition(query);
        if (CollectionUtils.isEmpty(blogDoList)) {
            return Collections.emptyList();
        }
        return blogDoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    private Blog toEntity(BlogDo blogDo) {
        return BlogDoConverter.INSTANCE.toEntity(blogDo);
    }

    private BlogDo toDo(Blog blog) {
        return BlogDoConverter.INSTANCE.toDo(blog);
    }
}
