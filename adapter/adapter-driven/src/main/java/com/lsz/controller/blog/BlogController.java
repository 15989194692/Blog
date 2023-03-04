package com.lsz.controller.blog;

import com.lsz.blog.BlogService;
import com.lsz.blog.dto.BlogDto;
import com.lsz.blog.dto.CreateBlogDto;
import com.lsz.blog.dto.DeleteBlogDto;
import com.lsz.controller.blog.assembler.BlogCommandAssembler;
import com.lsz.controller.blog.assembler.BlogQueryAssembler;
import com.lsz.controller.blog.request.CreateBlogRequest;
import com.lsz.controller.blog.request.DeleteBlogRequest;
import com.lsz.controller.blog.request.QueryBlogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName BlogController
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:16
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;


    @PostMapping("/createBlog")
    public CreateBlogDto createBlog(@RequestBody CreateBlogRequest request) {
        return blogService.createBlog(BlogCommandAssembler.INSTANCE.toCreateBlogCommand(request));
    }

    @PostMapping("/queryBlog")
    public List<BlogDto> queryBlog(@RequestBody QueryBlogRequest request) {
        return blogService.queryBlog(BlogQueryAssembler.INSTANCE.toBlogQuery(request));
    }

    @PostMapping("/deleteBlog")
    public DeleteBlogDto deleteBlog(@RequestBody DeleteBlogRequest request) {
        return blogService.deleteBlog(BlogCommandAssembler.INSTANCE.toDeleteBlogCommand(request));
    }

}
