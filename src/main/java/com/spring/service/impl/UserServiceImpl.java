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

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper dao;

    public User login(String username, String password) {
        User user = new User();
        user.setusername(username);
        user.setpassword(password);

        return this.dao.login(user);
    }

    public boolean updatePassword(int id, String newPassword) {
        User user = new User();
        user.setId(id);
        user.setpassword(newPassword);
        int i = this.dao.updateByPrimaryKeySelective(user);
        return i == 1;
    }

    /**
     * 获取所有数据
     * @return
     */
    public List<User> select() {
        return dao.select(null);
    }

    /**
     * 根据user类搜索数据
     * @param y
     * @return
     */
    public List<User> select(User y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取用户一行数据
     * @param id
     * @return
     */
    public User find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据用户获取用户类条件查询一行数据
     * @param id
     * @return
     */
    public User findEntity(User id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<User> selectPage(User obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<User> list = select(obj);
        PageInfo<User> pageInfo = new PageInfo(list);
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
    public List<User> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<User> list = dao.selectByExample(obj);
        PageInfo<User> pageInfo = new PageInfo(list);
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
     * 插入用户     * @param y
     * @return
     */
    public int insert(User y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新用户     * @param y
     * @return
     */
    public int update(User y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
