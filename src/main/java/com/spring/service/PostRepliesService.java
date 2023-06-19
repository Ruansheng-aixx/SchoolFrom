package com.spring.service;

import com.spring.entity.PostReplies;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface PostRepliesService {
    /**
     * 获取所有数据
     * @return
     */
    public List<PostReplies> select();

    /**
     * 根据postreplies类搜索数据
     * @param y
     * @return
     */
    public List<PostReplies> select(PostReplies y);

    /**
     * 根据主键获取帖子回复一行数据
     * @param id
     * @return
     */
    public PostReplies find(Object id);

    /**
     * 根据帖子回复获取帖子回复类条件查询一行数据
     * @param id
     * @return
     */
    public PostReplies findEntity(PostReplies id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<PostReplies> selectPage(PostReplies obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<PostReplies> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入帖子回复     * @param y
     * @return
     */
    public int insert(PostReplies y);

    /**
     * 更新帖子回复     * @param y
     * @return
     */
    public int update(PostReplies y);
}
