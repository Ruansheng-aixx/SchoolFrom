package com.spring.controller;

import com.spring.dao.*;
import com.spring.entity.Collections;
import com.spring.service.*;
import com.spring.util.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;

/**
 * 收藏 */
@Controller
public class CollectionsController extends BaseController {

    @Autowired
    private CollectionsMapper dao;

    @Autowired
    private CollectionsService service;

    /**
     *  后台列表页
     *
     */
    @RequestMapping("/collections_list")
    public String list() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }

        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc

        Example example = new Example(Collections.class); //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria(); // 创建一个扩展搜索条件类
        String where = " 1=1 "; // 创建初始条件为：1=1
        where += getWhere(); // 从方法中获取url 上的参数，并写成 sql条件语句
        criteria.andCondition(where); // 将条件写进上面的扩展条件类中
        if (sort.equals("desc")) { // 判断前台提交的sort 参数是否等于  desc倒序  是则使用倒序，否则使用正序
            example.orderBy(order).desc(); // 把sql 语句设置成倒序
        } else {
            example.orderBy(order).asc(); // 把 sql 设置成正序
        }
        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page")); // 获取前台提交的URL参数 page  如果没有则设置为1
        page = Math.max(1, page); // 取两个数的最大值，防止page 小于1
        List<Collections> list = service.selectPageExample(example, page, 12); // 获取当前页的行数
        // 将列表写给界面使用
        assign("list", list);
        assign("orderby", order); // 把当前排序结果写进前台
        assign("sort", sort); // 把当前排序结果写进前台
        assign("where", where); // 把当前条件写给前台
        return "collections_list"; // 使用视图文件：WebRoot\collections_list.jsp
    }

    /**
     *  获取前台搜索框填写的内容,并组成where 语句
     */
    public String getWhere() {
        String where = " ";
        // 以下是判断搜索框中是否有输入内容，判断是否前台是否有填写相关条件，符合则写入sql搜索语句
        if (!Request.get("biaoti").equals("")) {
            where += " AND biaoti LIKE '%" + Request.get("biaoti") + "%' ";
        }
        return where;
    }

    /**
     * 用户列表
     */
    @RequestMapping("/collections_list_username")
    public String listusername() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }

        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc

        Example example = new Example(Collections.class); //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria(); // 创建一个扩展搜索条件类
        // 初始化一个条件，条件为：用户=当前登录用户
        String where = " username='" + session.getAttribute("username") + "' ";
        where += getWhere();

        criteria.andCondition(where); // 将条件写入
        if (sort.equals("desc")) { // 注释同list
            example.orderBy(order).desc(); // 注释同list
        } else {
            example.orderBy(order).asc(); // 注释同list
        }

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page")); // 注释同list
        page = Math.max(1, page); // 注释同list

        List<Collections> list = service.selectPageExample(example, page, 12);

        request.setAttribute("list", list);
        assign("orderby", order);
        assign("sort", sort);
        assign("where", where);
        return "collections_list_username";
    }

    @RequestMapping("/collectionsadd")
    public String addWeb() {
        if (!checkLogin()) {
            return showError("尚未登录", "./");
        }
        return "collectionsadd";
    }

    /**
     * 添加内容
     * @return
     */
    @RequestMapping("/collectionsinsert")
    public String insert() {
        String tmp = "";
        Collections post = new Collections(); // 创建实体类
        // 设置前台提交上来的数据到实体类中
        post.setUsername((String) session.getAttribute("username"));

        post.setXwid(Request.getInt("xwid"));

        post.setBiao(Request.get("biao"));

        post.setBiaoti(Request.get("biaoti"));

        post.setAddtime(Info.getDateStr());

        Map res = Query.make("collections").where("biao", Request.get("biao")).where("xwid", Request.get("xwid")).where("username", session.getAttribute("username")).find();
        if (res != null && !res.isEmpty()) {
            Query.make("collections").where("id", res.get("id")).delete();
            return showSuccess("已取消收藏");
        }

        service.insert(post); // 插入数据
        int charuid = post.getId().intValue();

        return showSuccess("保存成功", Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    /**
     * 更新内容
     * @return
     */
    @RequestMapping("/collectionsupdate")
    public String update() {
        // 创建实体类
        Collections post = new Collections();
        // 将前台表单数据填充到实体类
        if (!Request.get("username").equals("")) post.setUsername(Request.get("username"));
        if (!Request.get("xwid").equals("")) post.setXwid(Request.getInt("xwid"));
        if (!Request.get("biao").equals("")) post.setBiao(Request.get("biao"));
        if (!Request.get("biaoti").equals("")) post.setBiaoti(Request.get("biaoti"));
        if (!Request.get("addtime").equals("")) post.setAddtime(Request.get("addtime"));

        post.setId(Request.getInt("id"));
        service.update(post); // 更新数据
        int charuid = post.getId().intValue();
        return showSuccess("保存成功", Request.get("referer")); // 弹出保存成功，并跳转到前台提交的 referer 页面
    }

    @RequestMapping("/collections_batch")
    public String batch() {
        if (
            request.getParameter("delete") != null
        ) { // 执行批量删除，根据前台表单的选项 生成 数组ids
            String[] ids = request.getParameterValues("ids"); // 获取前台选择的复选框
            if (ids != null) Query.make("collections").where("id", "in", ids).delete(); // 执行删除
        }
        return showSuccess("批量处理成功", request.getHeader("referer")); //弹出批量处理成功，并调回上一页
    }

    /**
     *  删除
     */
    @RequestMapping("/collections_delete")
    public String delete() {
        if (!checkLogin()) {
            return showError("尚未登录");
        }
        int id = Request.getInt("id"); // 根据id 删除某行数据
        Map map = Query.make("collections").find(id);

        service.delete(id); // 根据id 删除某行数据
        return showSuccess("删除成功", request.getHeader("referer")); //弹出删除成功，并跳回上一页
    }
}
