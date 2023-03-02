package com.lsz.blog;

import com.lsz.valueobject.UserId;

import java.util.List;

/**
 * @ClassName Blog
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:00
 * @Version 1.0.0
 **/
public class Blog {

    private String blogId;

    private UserId userId;

    private String blogTitle;

    private String blogContent;

    private List<Comment> commentList;



}
