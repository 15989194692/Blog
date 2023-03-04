package com.lsz.blog;

import com.lsz.blog.domain.Blog;
import com.lsz.blog.query.BlogQuery;

import java.util.List;

/**
 * @ClassName BlogRepository
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/3 上午8:36
 * @Version 1.0.0
 **/
public interface BlogRepository {

    boolean save(Blog blog);

    Blog queryById(String blogId);

    List<Blog> query(BlogQuery query);



}
