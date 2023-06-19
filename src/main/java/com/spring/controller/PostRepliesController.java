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
 * 帖子回复 */
@Controller
public class PostRepliesController extends BaseController {

    @Autowired
    private PostRepliesMapper dao;

    @Autowired
    private PostRepliesService service;

    @Autowired
    private ForumPostsService serviceRead;

    /**
     *  后台列表页
     *
     */
    @RequestMapping("/postreplies_list")
    public String list() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }

        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc

        Example example = new Example(PostReplies.class); //  创建一个扩展搜索类
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
        List<PostReplies> list = service.selectPageExample(example, page, 12); // 获取当前页的行数
        // 将列表写给界面使用
        assign("list", list);
        assign("orderby", order); // 把当前排序结果写进前台
        assign("sort", sort); // 把当前排序结果写进前台
        assign("where", where); // 把当前条件写给前台
        return "postreplies_list"; // 使用视图文件：WebRoot\postreplies_list.jsp
    }

    /**
     *  获取前台搜索框填写的内容,并组成where 语句
     */
    public String getWhere() {
        String where = " ";
        // 判断URL 参数forumpostid是否大于0
        if (Request.getInt("forumpostid") > 0) {
            // 大于0 则写入条件
            where += " AND forumpostid='" + Request.getInt("forumpostid") + "' ";
        }
        // 以下是判断搜索框中是否有输入内容，判断是否前台是否有填写相关条件，符合则写入sql搜索语句
        if (!Request.get("postnumber").equals("")) {
            where += " AND postnumber LIKE '%" + Request.get("postnumber") + "%' ";
        }
        if (!Request.get("categorization").equals("")) {
            where += " AND categorization ='" + Request.get("categorization") + "' ";
        }
        return where;
    }

    /**
     * 发布人列表
     */
    @RequestMapping("/postreplies_list_publisher")
    public String listpublisher() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }

        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc

        Example example = new Example(PostReplies.class); //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria(); // 创建一个扩展搜索条件类
        // 初始化一个条件，条件为：发布人=当前登录用户
        String where = " publisher='" + session.getAttribute("username") + "' ";
        where += getWhere();

        criteria.andCondition(where); // 将条件写入
        if (sort.equals("desc")) { // 注释同list
            example.orderBy(order).desc(); // 注释同list
        } else {
            example.orderBy(order).asc(); // 注释同list
        }

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page")); // 注释同list
        page = Math.max(1, page); // 注释同list

        List<PostReplies> list = service.selectPageExample(example, page, 12);

        request.setAttribute("list", list);
        assign("orderby", order);
        assign("sort", sort);
        assign("where", where);
        return "postreplies_list_publisher";
    }

    /**
     * 回复人列表
     */
    @RequestMapping("/postreplies_list_replypeople")
    public String listreplypeople() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }

        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc

        Example example = new Example(PostReplies.class); //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria(); // 创建一个扩展搜索条件类
        // 初始化一个条件，条件为：回复人=当前登录用户
        String where = " replypeople='" + session.getAttribute("username") + "' ";
        where += getWhere();

        criteria.andCondition(where); // 将条件写入
        if (sort.equals("desc")) { // 注释同list
            example.orderBy(order).desc(); // 注释同list
        } else {
            example.orderBy(order).asc(); // 注释同list
        }

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page")); // 注释同list
        page = Math.max(1, page); // 注释同list

        List<PostReplies> list = service.selectPageExample(example, page, 12);

        request.setAttribute("list", list);
        assign("orderby", order);
        assign("sort", sort);
        assign("where", where);
        return "postreplies_list_replypeople";
    }

    @RequestMapping("/postreplies_add")
    public String add() {
        int id = Request.getInt("id"); // 根据id 获取 论坛帖子模块中的数据
        ForumPosts readMap = serviceRead.find(id);
        // 将数据行写入给前台jsp页面
        request.setAttribute("readMap", readMap);
        return "postreplies_add";
    }

    @RequestMapping("/postrepliesadd")
    public String addWeb() {
        if (!checkLogin()) {
            return showError("尚未登录", "./");
        }
        int id = Request.getInt("id"); // 根据id 获取 论坛帖子模块中的数据
        ForumPosts readMap = serviceRead.find(id);
        request.setAttribute("readMap", readMap);
        return "postrepliesadd";
    }

    @RequestMapping("/postreplies_updt")
    public String updt() {
        int id = Request.getInt("id");
        // 获取行数据，并赋值给前台jsp页面
        PostReplies mmm = service.find(id);
        request.setAttribute("mmm", mmm);
        request.setAttribute("updtself", 0);
        return "postreplies_updt";
    }

    /**
     * 添加内容
     * @return
     */
    @RequestMapping("/postrepliesinsert")
    public String insert() {
        String tmp = "";
        PostReplies post = new PostReplies(); // 创建实体类
        // 设置前台提交上来的数据到实体类中
        post.setforumpostid(Request.getInt("forumpostid"));

        post.setpostnumber(Request.get("postnumber"));

        post.setcategorization(Request.get("categorization"));

        post.setpostname(Request.get("postname"));

        post.setpublisher(Request.get("publisher"));

        post.setreplytime(Info.getDateStr());

        post.setreplycontent(Request.get("replycontent"));

        post.setreplypeople(Request.get("replypeople"));

        post.setforumpostid(Request.getInt("forumpostid"));

        service.insert(post); // 插入数据
        int charuid = post.getId().intValue();

        return showSuccess("保存成功", Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    /**
     * 更新内容
     * @return
     */
    @RequestMapping("/postrepliesupdate")
    public String update() {
        // 创建实体类
        PostReplies post = new PostReplies();
        // 将前台表单数据填充到实体类
        if (!Request.get("forumpostid").equals("")) post.setforumpostid(Request.getInt("forumpostid"));
        if (!Request.get("postnumber").equals("")) post.setpostnumber(Request.get("postnumber"));
        if (!Request.get("categorization").equals("")) post.setcategorization(Request.get("categorization"));
        if (!Request.get("postname").equals("")) post.setpostname(Request.get("postname"));
        if (!Request.get("publisher").equals("")) post.setpublisher(Request.get("publisher"));
        if (!Request.get("replytime").equals("")) post.setreplytime(Request.get("replytime"));
        if (!Request.get("replycontent").equals("")) post.setreplycontent(Request.get("replycontent"));
        if (!Request.get("replypeople").equals("")) post.setreplypeople(Request.get("replypeople"));

        post.setId(Request.getInt("id"));
        service.update(post); // 更新数据
        int charuid = post.getId().intValue();
        return showSuccess("保存成功", Request.get("referer")); // 弹出保存成功，并跳转到前台提交的 referer 页面
    }

    /**
     *  后台详情
     */
    @RequestMapping("/postreplies_detail")
    public String detail() {
        int id = Request.getInt("id");
        PostReplies map = service.find(id); // 根据前台url 参数中的id获取行数据
        request.setAttribute("map", map); // 把数据写到前台
        return "postreplies_detail"; // 详情页面：WebRoot\postreplies_detail.jsp
    }

    /**
     *  删除
     */
    @RequestMapping("/postreplies_delete")
    public String delete() {
        if (!checkLogin()) {
            return showError("尚未登录");
        }
        int id = Request.getInt("id"); // 根据id 删除某行数据
        Map map = Query.make("postreplies").find(id);

        service.delete(id); // 根据id 删除某行数据
        return showSuccess("删除成功", request.getHeader("referer")); //弹出删除成功，并跳回上一页
    }
}
