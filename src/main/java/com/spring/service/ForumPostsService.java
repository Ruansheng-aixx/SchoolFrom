package com.spring.service;

import com.spring.entity.ForumPosts;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface ForumPostsService {
    /**
     * 获取所有数据
     * @return
     */
    public List<ForumPosts> select();

    /**
     * 根据forumposts类搜索数据
     * @param y
     * @return
     */
    public List<ForumPosts> select(ForumPosts y);

    /**
     * 根据主键获取论坛帖子一行数据
     * @param id
     * @return
     */
    public ForumPosts find(Object id);

    /**
     * 根据论坛帖子获取论坛帖子类条件查询一行数据
     * @param id
     * @return
     */
    public ForumPosts findEntity(ForumPosts id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<ForumPosts> selectPage(ForumPosts obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<ForumPosts> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入论坛帖子     * @param y
     * @return
     */
    public int insert(ForumPosts y);

    /**
     * 更新论坛帖子     * @param y
     * @return
     */
    public int update(ForumPosts y);
}
