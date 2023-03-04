/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.blog.query;

import java.util.List;

/**
 * @author lishuzeng
 * @version : BlogQuery.java, v 0.1 2023年03月04日 下午5:26 lishuzeng Exp $
 */
public class BlogQuery {

    private List<String> blogTileList;

    private List<String> userIdList;

    private List<String> blogIdList;

    public List<String> getBlogTileList() {
        return blogTileList;
    }

    public void setBlogTileList(List<String> blogTileList) {
        this.blogTileList = blogTileList;
    }

    public List<String> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<String> userIdList) {
        this.userIdList = userIdList;
    }

    public List<String> getBlogIdList() {
        return blogIdList;
    }

    public void setBlogIdList(List<String> blogIdList) {
        this.blogIdList = blogIdList;
    }
}