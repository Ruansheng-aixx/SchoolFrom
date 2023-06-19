package com.spring.service;

import com.spring.entity.User;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface UserService {
    public User login(String username, String password);

    public boolean updatePassword(int id, String newPassword);

    /**
     * 获取所有数据
     * @return
     */
    public List<User> select();

    /**
     * 根据user类搜索数据
     * @param y
     * @return
     */
    public List<User> select(User y);

    /**
     * 根据主键获取用户一行数据
     * @param id
     * @return
     */
    public User find(Object id);

    /**
     * 根据用户获取用户类条件查询一行数据
     * @param id
     * @return
     */
    public User findEntity(User id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<User> selectPage(User obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<User> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入用户     * @param y
     * @return
     */
    public int insert(User y);

    /**
     * 更新用户     * @param y
     * @return
     */
    public int update(User y);
}
