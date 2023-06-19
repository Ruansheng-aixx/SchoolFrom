package com.spring.service;

import com.spring.entity.PostCategorization;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface PostCategorizationService {
    /**
     * 获取所有数据
     * @return
     */
    public List<PostCategorization> select();

    /**
     * 根据postcategorization类搜索数据
     * @param y
     * @return
     */
    public List<PostCategorization> select(PostCategorization y);

    /**
     * 根据主键获取帖子分类一行数据
     * @param id
     * @return
     */
    public PostCategorization find(Object id);

    /**
     * 根据帖子分类获取帖子分类类条件查询一行数据
     * @param id
     * @return
     */
    public PostCategorization findEntity(PostCategorization id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<PostCategorization> selectPage(PostCategorization obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<PostCategorization> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入帖子分类     * @param y
     * @return
     */
    public int insert(PostCategorization y);

    /**
     * 更新帖子分类     * @param y
     * @return
     */
    public int update(PostCategorization y);
}
