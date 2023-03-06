package com.lsz.blog;

import com.lsz.blog.assembler.BlogDtoAssembler;
import com.lsz.blog.assembler.CommentDtoAssembler;
import com.lsz.blog.builder.BlogBuilderFactory;
import com.lsz.blog.builder.CommentBuilderFactory;
import com.lsz.blog.command.CommentBlogCommand;
import com.lsz.blog.command.CreateBlogCommand;
import com.lsz.blog.command.DeleteBlogCommand;
import com.lsz.blog.command.DeleteBlogCommentCommand;
import com.lsz.blog.domain.Blog;
import com.lsz.blog.domain.Comment;
import com.lsz.blog.dto.*;
import com.lsz.blog.query.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName BlogServiceImpl
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/3 上午8:42
 * @Version 1.0.0
 **/
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private BlogBuilderFactory blogBuilderFactory;


    @Autowired
    private CommentBuilderFactory commentBuilderFactory;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public CreateBlogDto createBlog(CreateBlogCommand command) {
        Blog blog = blogBuilderFactory.builder()
                .blogTitle(command.getBlogTitle())
                .blogContent(command.getBlogContent())
                .userId(command.getUserId())
                .status(command.getStatus())
                .build();
        blogRepository.save(blog);
        return BlogDtoAssembler.INSTANCE.toCreateBlogDto(blog);
    }

    @Override
    public CommentBlogDto commentBlog(CommentBlogCommand command) {
        Comment comment = commentBuilderFactory.builder()
                .blogId(command.getBlogId())
                .userId(command.getUserId())
                .parentCommentId(command.getParentCommentId())
                .commentContent(command.getCommentContent())
                .build();
        commentRepository.save(comment);
        return CommentDtoAssembler.INSTANCE.toCommentBlogDto(comment);
    }

    @Override
    public List<BlogDto> queryBlog(BlogQuery query) {
        List<Blog> blogList = blogRepository.query(query);
        return blogList.stream().map(BlogDtoAssembler.INSTANCE::toBlogDto).collect(Collectors.toList());
    }

    @Override
    public DeleteBlogDto deleteBlog(DeleteBlogCommand command) {
        Blog blog = blogRepository.queryById(command.getBlogId());
        blog.delete(command.getUserId());
        boolean success = blogRepository.save(blog);
        return new DeleteBlogDto(success);
    }

    @Override
    public DeleteBlogCommentDto deleteBlogComment(DeleteBlogCommentCommand command) {
        Comment comment = commentRepository.queryById(command.getCommentId());
        comment.deleteComment(command.getUserId());
        boolean deleteSuccess = commentRepository.save(comment);
        return new DeleteBlogCommentDto(deleteSuccess);
    }


}
