package com.spring.service;

import com.spring.entity.Announcement;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface AnnouncementService {
    /**
     * 获取所有数据
     * @return
     */
    public List<Announcement> select();

    /**
     * 根据announcement类搜索数据
     * @param y
     * @return
     */
    public List<Announcement> select(Announcement y);

    /**
     * 根据主键获取公告一行数据
     * @param id
     * @return
     */
    public Announcement find(Object id);

    /**
     * 根据公告获取公告类条件查询一行数据
     * @param id
     * @return
     */
    public Announcement findEntity(Announcement id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Announcement> selectPage(Announcement obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Announcement> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入公告     * @param y
     * @return
     */
    public int insert(Announcement y);

    /**
     * 更新公告     * @param y
     * @return
     */
    public int update(Announcement y);
}
