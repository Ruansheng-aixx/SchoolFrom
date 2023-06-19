package com.spring.service;

import com.spring.entity.MessageBoards;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface MessageBoardsService {
    /**
     * 获取所有数据
     * @return
     */
    public List<MessageBoards> select();

    /**
     * 根据messageboards类搜索数据
     * @param y
     * @return
     */
    public List<MessageBoards> select(MessageBoards y);

    /**
     * 根据主键获取留言板一行数据
     * @param id
     * @return
     */
    public MessageBoards find(Object id);

    /**
     * 根据留言板获取留言板类条件查询一行数据
     * @param id
     * @return
     */
    public MessageBoards findEntity(MessageBoards id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<MessageBoards> selectPage(MessageBoards obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<MessageBoards> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入留言板     * @param y
     * @return
     */
    public int insert(MessageBoards y);

    /**
     * 更新留言板     * @param y
     * @return
     */
    public int update(MessageBoards y);
}
