package com.lsz.blog;

import com.lsz.blog.command.CommentBlogCommand;
import com.lsz.blog.command.CreateBlogCommand;
import com.lsz.blog.command.DeleteBlogCommand;
import com.lsz.blog.command.DeleteBlogCommentCommand;
import com.lsz.blog.dto.*;
import com.lsz.blog.query.BlogQuery;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName BlogService
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:01
 * @Version 1.0.0
 **/
public interface BlogService {


    /**
     * 创建博客
     *
     * @param command 命令
     * @return 博客
     */
    CreateBlogDto createBlog(@Valid CreateBlogCommand command);


    CommentBlogDto commentBlog(CommentBlogCommand command);


    List<BlogDto> queryBlog(BlogQuery query);


    DeleteBlogDto deleteBlog(DeleteBlogCommand command);

    DeleteBlogCommentDto deleteBlogComment(DeleteBlogCommentCommand command);

}
