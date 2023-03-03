package com.lsz.persistence.blog;

import com.lsz.blog.Blog;
import com.lsz.blog.BlogRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName BlogRepositoryJdbc
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/3 上午8:37
 * @Version 1.0.0
 **/
@Repository
public class BlogRepositoryJdbc implements BlogRepository {

    @Override
    public boolean save(Blog blog) {
        return false;
    }

    @Override
    public Blog queryById(String blogId) {
        return null;
    }
}
