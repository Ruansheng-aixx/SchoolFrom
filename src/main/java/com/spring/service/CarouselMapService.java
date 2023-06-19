package com.spring.service;

import com.spring.entity.CarouselMap;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface CarouselMapService {
    /**
     * 获取所有数据
     * @return
     */
    public List<CarouselMap> select();

    /**
     * 根据carouselmap类搜索数据
     * @param y
     * @return
     */
    public List<CarouselMap> select(CarouselMap y);

    /**
     * 根据主键获取轮播图一行数据
     * @param id
     * @return
     */
    public CarouselMap find(Object id);

    /**
     * 根据轮播图获取轮播图类条件查询一行数据
     * @param id
     * @return
     */
    public CarouselMap findEntity(CarouselMap id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<CarouselMap> selectPage(CarouselMap obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<CarouselMap> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入轮播图     * @param y
     * @return
     */
    public int insert(CarouselMap y);

    /**
     * 更新轮播图     * @param y
     * @return
     */
    public int update(CarouselMap y);
}
