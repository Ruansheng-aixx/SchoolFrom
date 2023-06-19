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

@Service("postrepliesService")
public class PostRepliesServiceImpl implements PostRepliesService {

    @Resource
    private PostRepliesMapper dao;

    /**
     * 获取所有数据
     * @return
     */
    public List<PostReplies> select() {
        return dao.select(null);
    }

    /**
     * 根据postreplies类搜索数据
     * @param y
     * @return
     */
    public List<PostReplies> select(PostReplies y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取帖子回复一行数据
     * @param id
     * @return
     */
    public PostReplies find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据帖子回复获取帖子回复类条件查询一行数据
     * @param id
     * @return
     */
    public PostReplies findEntity(PostReplies id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<PostReplies> selectPage(PostReplies obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<PostReplies> list = select(obj);
        PageInfo<PostReplies> pageInfo = new PageInfo(list);
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
    public List<PostReplies> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<PostReplies> list = dao.selectByExample(obj);
        PageInfo<PostReplies> pageInfo = new PageInfo(list);
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
     * 插入帖子回复     * @param y
     * @return
     */
    public int insert(PostReplies y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新帖子回复     * @param y
     * @return
     */
    public int update(PostReplies y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
