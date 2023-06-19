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

@Service("postcategorizationService")
public class PostCategorizationServiceImpl implements PostCategorizationService {

    @Resource
    private PostCategorizationMapper dao;

    /**
     * 获取所有数据
     * @return
     */
    public List<PostCategorization> select() {
        return dao.select(null);
    }

    /**
     * 根据postcategorization类搜索数据
     * @param y
     * @return
     */
    public List<PostCategorization> select(PostCategorization y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取帖子分类一行数据
     * @param id
     * @return
     */
    public PostCategorization find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据帖子分类获取帖子分类类条件查询一行数据
     * @param id
     * @return
     */
    public PostCategorization findEntity(PostCategorization id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<PostCategorization> selectPage(PostCategorization obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<PostCategorization> list = select(obj);
        PageInfo<PostCategorization> pageInfo = new PageInfo(list);
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
    public List<PostCategorization> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<PostCategorization> list = dao.selectByExample(obj);
        PageInfo<PostCategorization> pageInfo = new PageInfo(list);
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
     * 插入帖子分类     * @param y
     * @return
     */
    public int insert(PostCategorization y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新帖子分类     * @param y
     * @return
     */
    public int update(PostCategorization y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
