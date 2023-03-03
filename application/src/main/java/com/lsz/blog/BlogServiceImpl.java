package com.lsz.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
