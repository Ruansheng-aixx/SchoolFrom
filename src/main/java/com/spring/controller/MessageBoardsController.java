package com.spring.controller;

import com.spring.dao.*;
import com.spring.entity.*;
import com.spring.service.*;
import com.spring.util.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;

/**
 * 留言板 */
@Controller
public class MessageBoardsController extends BaseController {

    @Autowired
    private MessageBoardsMapper dao;

    @Autowired
    private MessageBoardsService service;

    /**
     *  后台列表页
     *
     */
    @RequestMapping("/messageboards_list")
    public String list() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }

        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc

        Example example = new Example(MessageBoards.class); //  创建一个扩展搜索类
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
        List<MessageBoards> list = service.selectPageExample(example, page, 12); // 获取当前页的行数
        // 将列表写给界面使用
        assign("list", list);
        assign("orderby", order); // 把当前排序结果写进前台
        assign("sort", sort); // 把当前排序结果写进前台
        assign("where", where); // 把当前条件写给前台
        return "messageboards_list"; // 使用视图文件：WebRoot\messageboards_list.jsp
    }

    /**
     *  获取前台搜索框填写的内容,并组成where 语句
     */
    public String getWhere() {
        String where = " ";
        // 以下是判断搜索框中是否有输入内容，判断是否前台是否有填写相关条件，符合则写入sql搜索语句
        return where;
    }

    /**
     * 留言人列表
     */
    @RequestMapping("/messageboards_list_messageperson")
    public String listmessageperson() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }

        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc

        Example example = new Example(MessageBoards.class); //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria(); // 创建一个扩展搜索条件类
        // 初始化一个条件，条件为：留言人=当前登录用户
        String where = " messageperson='" + session.getAttribute("username") + "' ";
        where += getWhere();

        criteria.andCondition(where); // 将条件写入
        if (sort.equals("desc")) { // 注释同list
            example.orderBy(order).desc(); // 注释同list
        } else {
            example.orderBy(order).asc(); // 注释同list
        }

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page")); // 注释同list
        page = Math.max(1, page); // 注释同list

        List<MessageBoards> list = service.selectPageExample(example, page, 12);

        request.setAttribute("list", list);
        assign("orderby", order);
        assign("sort", sort);
        assign("where", where);
        return "messageboards_list_messageperson";
    }

    @RequestMapping("/messageboards_add")
    public String add() {
        return "messageboards_add";
    }

    @RequestMapping("/messageboardsadd")
    public String addWeb() {
        if (!checkLogin()) {
            return showError("尚未登录", "./");
        }
        return "messageboardsadd";
    }

    @RequestMapping("/messageboards_updt")
    public String updt() {
        int id = Request.getInt("id");
        // 获取行数据，并赋值给前台jsp页面
        MessageBoards mmm = service.find(id);
        request.setAttribute("mmm", mmm);
        request.setAttribute("updtself", 0);
        return "messageboards_updt";
    }

    /**
     * 添加内容
     * @return
     */
    @RequestMapping("/messageboardsinsert")
    public String insert() {
        String tmp = "";
        MessageBoards post = new MessageBoards(); // 创建实体类
        // 设置前台提交上来的数据到实体类中
        post.setname(Request.get("name"));

        post.setcontactnumber(Request.get("contactnumber"));

        post.setmessagecontent(Request.get("messagecontent"));

        post.setmessageperson(Request.get("messageperson"));

        post.setreplycontent(Request.get("replycontent"));

        service.insert(post); // 插入数据
        int charuid = post.getId().intValue();

        return showSuccess("保存成功", Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    /**
     * 更新内容
     * @return
     */
    @RequestMapping("/messageboardsupdate")
    public String update() {
        // 创建实体类
        MessageBoards post = new MessageBoards();
        // 将前台表单数据填充到实体类
        if (!Request.get("name").equals("")) post.setname(Request.get("name"));
        if (!Request.get("contactnumber").equals("")) post.setcontactnumber(Request.get("contactnumber"));
        if (!Request.get("messagecontent").equals("")) post.setmessagecontent(Request.get("messagecontent"));
        if (!Request.get("messageperson").equals("")) post.setmessageperson(Request.get("messageperson"));
        if (!Request.get("replycontent").equals("")) post.setreplycontent(Request.get("replycontent"));

        post.setId(Request.getInt("id"));
        service.update(post); // 更新数据
        int charuid = post.getId().intValue();
        return showSuccess("保存成功", Request.get("referer")); // 弹出保存成功，并跳转到前台提交的 referer 页面
    }

    /**
     *  删除
     */
    @RequestMapping("/messageboards_delete")
    public String delete() {
        if (!checkLogin()) {
            return showError("尚未登录");
        }
        int id = Request.getInt("id"); // 根据id 删除某行数据
        Map map = Query.make("messageboards").find(id);

        service.delete(id); // 根据id 删除某行数据
        return showSuccess("删除成功", request.getHeader("referer")); //弹出删除成功，并跳回上一页
    }
}
