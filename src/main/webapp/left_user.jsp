<%@ page language="java" pageEncoding="UTF-8" %>
 <%@ page language="java" import="java.util.*" %>
 <%@page import="com.spring.util.*" %>
 <%@page import="com.jntoo.db.*" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<li>
    <a href="javascript:;" class="nav-top-item">
        <i class="icon ti-home"></i>
        <span>论坛帖子管理</span>
    </a>
    <ul>
        <li>
            <a target="main" href="forumposts_add.do"> 论坛帖子发布 </a>
        </li>
        <li>
            <a target="main" href="forumposts_list_publisher.do"> 我发布的帖子 </a>
        </li>
        <li>
            <a target="main" href="postreplies_list_replypeople.do"> 我回复的帖子 </a>
        </li>
    </ul>
</li>
<li>
    <a href="javascript:;" class="nav-top-item">
        <i class="icon ti-home"></i>
        <span>个人中心</span>
    </a>
    <ul>
        <li>
            <a target="main" href="user_updtself.do"> 修改个人资料 </a>
        </li>
        <li>
            <a target="main" href="mod.do"> 修改密码 </a>
        </li>
        <li>
            <a target="main" href="collections_list_username.do"> 我的收藏 </a>
        </li>
        <li>
            <a target="main" href="messageboards_list_messageperson.do"> 我的留言 </a>
        </li>
    </ul>
</li>
