package com.spring.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.dao.*;
import com.spring.entity.*;
import com.spring.service.*;
import com.spring.util.*;
import java.util.*;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service("announcementService")
public class AnnouncementServiceImpl implements AnnouncementService {

    @Resource
    private AnnouncementMapper dao;

    /**
     * 获取所有数据
     * @return
     */
    public List<Announcement> select() {
        return dao.select(null);
    }

    /**
     * 根据announcement类搜索数据
     * @param y
     * @return
     */
    public List<Announcement> select(Announcement y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取公告一行数据
     * @param id
     * @return
     */
    public Announcement find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据公告获取公告类条件查询一行数据
     * @param id
     * @return
     */
    public Announcement findEntity(Announcement id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Announcement> selectPage(Announcement obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Announcement> list = select(obj);
        PageInfo<Announcement> pageInfo = new PageInfo(list);
        PageInfoUtil pageInfoUtil = new PageInfoUtil(page);
        pageInfoUtil.setPageInfo(Request.getRequest(), pageInfo.getTotal(), pageSize);
        return list;
    }

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Announcement> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Announcement> list = dao.selectByExample(obj);
        PageInfo<Announcement> pageInfo = new PageInfo(list);
        PageInfoUtil pageInfoUtil = new PageInfoUtil(page);
        pageInfoUtil.setPageInfo(Request.getRequest(), pageInfo.getTotal(), pageSize);
        return list;
    }

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id) {
        return dao.deleteByPrimaryKey(id);
    }

    /**
     * 插入公告     * @param y
     * @return
     */
    public int insert(Announcement y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新公告     * @param y
     * @return
     */
    public int update(Announcement y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
