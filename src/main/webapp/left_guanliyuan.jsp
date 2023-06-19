<%@ page language="java" pageEncoding="UTF-8" %>
 <%@ page language="java" import="java.util.*" %>
 <%@page import="com.spring.util.*" %>
 <%@page import="com.jntoo.db.*" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<li>
    <a href="javascript:;" class="nav-top-item">
        <i class="icon ti-home"></i>
        <span>账号管理</span>
    </a>
    <ul>
        <li>
            <a target="main" href="admins_list.do"> 管理员账号管理 </a>
        </li>
        <li>
            <a target="main" href="admins_add.do"> 管理员账号添加 </a>
        </li>
        <li>
            <a target="main" href="mod.do"> 密码修改 </a>
        </li>
    </ul>
</li>
<li>
    <a href="javascript:;" class="nav-top-item">
        <i class="icon ti-home"></i>
        <span>用户管理</span>
    </a>
    <ul>
        <li>
            <a target="main" href="user_add.do"> 用户添加 </a>
        </li>
        <li>
            <a target="main" href="user_list.do"> 用户查询 </a>
        </li>
    </ul>
</li>
<li>
    <a href="javascript:;" class="nav-top-item">
        <i class="icon ti-home"></i>
        <span>公告管理</span>
    </a>
    <ul>
        <li>
            <a target="main" href="announcement_add.do"> 公告添加 </a>
        </li>
        <li>
            <a target="main" href="announcement_list.do"> 公告查询 </a>
        </li>
    </ul>
</li>
<li>
    <a href="javascript:;" class="nav-top-item">
        <i class="icon ti-home"></i>
        <span>帖子分类管理</span>
    </a>
    <ul>
        <li>
            <a target="main" href="postcategorization_add.do"> 帖子分类添加 </a>
        </li>
        <li>
            <a target="main" href="postcategorization_list.do"> 帖子分类查询 </a>
        </li>
    </ul>
</li>
<li>
    <a href="javascript:;" class="nav-top-item">
        <i class="icon ti-home"></i>
        <span>论坛帖子管理</span>
    </a>
    <ul>
        <li>
            <a target="main" href="forumposts_add.do"> 论坛帖子添加 </a>
        </li>
        <li>
            <a target="main" href="forumposts_list.do"> 论坛帖子查询 </a>
        </li>
    </ul>
</li>
<li>
    <a href="javascript:;" class="nav-top-item">
        <i class="icon ti-home"></i>
        <span>帖子回复管理</span>
    </a>
    <ul>
        <li>
            <a target="main" href="postreplies_list.do"> 帖子回复查询 </a>
        </li>
    </ul>
</li>
<li>
    <a href="javascript:;" class="nav-top-item">
        <i class="icon ti-home"></i>
        <span>系统管理</span>
    </a>
    <ul>
        <li>
            <a target="main" href="carouselmap_add.do"> 轮播图添加 </a>
        </li>
        <li>
            <a target="main" href="carouselmap_list.do"> 轮播图查询 </a>
        </li>
        <li>
            <a target="main" href="messageboards_list.do"> 留言管理 </a>
        </li>
    </ul>
</li>
