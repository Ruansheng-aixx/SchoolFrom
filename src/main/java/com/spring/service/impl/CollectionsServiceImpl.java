package com.spring.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.dao.*;
import com.spring.entity.Collections;
import com.spring.service.*;
import com.spring.util.*;
import java.util.*;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service("collectionsService")
public class CollectionsServiceImpl implements CollectionsService {

    @Resource
    private CollectionsMapper dao;

    /**
     * 获取所有数据
     * @return
     */
    public List<Collections> select() {
        return dao.select(null);
    }

    /**
     * 根据collections类搜索数据
     * @param y
     * @return
     */
    public List<Collections> select(Collections y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取收藏一行数据
     * @param id
     * @return
     */
    public Collections find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据收藏获取收藏类条件查询一行数据
     * @param id
     * @return
     */
    public Collections findEntity(Collections id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Collections> selectPage(Collections obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Collections> list = select(obj);
        PageInfo<Collections> pageInfo = new PageInfo(list);
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
    public List<Collections> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Collections> list = dao.selectByExample(obj);
        PageInfo<Collections> pageInfo = new PageInfo(list);
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
     * 插入收藏     * @param y
     * @return
     */
    public int insert(Collections y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新收藏     * @param y
     * @return
     */
    public int update(Collections y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
