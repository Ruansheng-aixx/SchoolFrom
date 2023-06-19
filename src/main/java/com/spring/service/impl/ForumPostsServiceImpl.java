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

@Service("forumpostsService")
public class ForumPostsServiceImpl implements ForumPostsService {

    @Resource
    private ForumPostsMapper dao;

    /**
     * 获取所有数据
     * @return
     */
    public List<ForumPosts> select() {
        return dao.select(null);
    }

    /**
     * 根据forumposts类搜索数据
     * @param y
     * @return
     */
    public List<ForumPosts> select(ForumPosts y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取论坛帖子一行数据
     * @param id
     * @return
     */
    public ForumPosts find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据论坛帖子获取论坛帖子类条件查询一行数据
     * @param id
     * @return
     */
    public ForumPosts findEntity(ForumPosts id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<ForumPosts> selectPage(ForumPosts obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<ForumPosts> list = select(obj);
        PageInfo<ForumPosts> pageInfo = new PageInfo(list);
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
    public List<ForumPosts> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<ForumPosts> list = dao.selectByExample(obj);
        PageInfo<ForumPosts> pageInfo = new PageInfo(list);
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
     * 插入论坛帖子     * @param y
     * @return
     */
    public int insert(ForumPosts y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新论坛帖子     * @param y
     * @return
     */
    public int update(ForumPosts y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
