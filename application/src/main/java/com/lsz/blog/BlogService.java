package com.lsz.blog;

import com.lsz.blog.command.CommentBlogCommand;
import com.lsz.blog.command.CreateBlogCommand;
import com.lsz.blog.command.DeleteBlogCommand;
import com.lsz.blog.dto.BlogDto;
import com.lsz.blog.dto.CommentBlogDto;
import com.lsz.blog.dto.CreateBlogDto;
import com.lsz.blog.dto.DeleteBlogDto;
import com.lsz.blog.query.BlogQuery;

import java.util.List;

/**
 * @ClassName BlogService
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:01
 * @Version 1.0.0
 **/
public interface BlogService {


    CreateBlogDto createBlog(CreateBlogCommand command);


    CommentBlogDto commentBlog(CommentBlogCommand command);


    List<BlogDto> queryBlog(BlogQuery query);


    DeleteBlogDto deleteBlog(DeleteBlogCommand command);

}
