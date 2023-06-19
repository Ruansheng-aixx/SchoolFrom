package com.spring.service;

import com.spring.entity.Collections;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface CollectionsService {
    /**
     * 获取所有数据
     * @return
     */
    public List<Collections> select();

    /**
     * 根据collections类搜索数据
     * @param y
     * @return
     */
    public List<Collections> select(Collections y);

    /**
     * 根据主键获取收藏一行数据
     * @param id
     * @return
     */
    public Collections find(Object id);

    /**
     * 根据收藏获取收藏类条件查询一行数据
     * @param id
     * @return
     */
    public Collections findEntity(Collections id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Collections> selectPage(Collections obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Collections> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入收藏     * @param y
     * @return
     */
    public int insert(Collections y);

    /**
     * 更新收藏     * @param y
     * @return
     */
    public int update(Collections y);
}
