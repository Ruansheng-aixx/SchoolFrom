<%@ page language="java" pageEncoding="UTF-8" %>
 <%@ page language="java" import="java.util.*" %>
 <%@page import="com.spring.util.*" %>
 <%@page import="com.jntoo.db.*" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="head.jsp" %>


<div style="padding: 10px" class="admin-content">
    <div class="panel panel-default">
        <div class="panel-heading">用户详情</div>
        <div class="panel-body">
            <div class="admin-detail clearfix">
                <div class="detail detail-text">
                    <div class="detail-title">用户名：</div>
                    <div class="detail-content">${map.username}</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">姓名：</div>
                    <div class="detail-content">${map.name}</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">联系电话：</div>
                    <div class="detail-content">${map.contactnumber}</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">邮箱：</div>
                    <div class="detail-content">${map.mailbox}</div>
                </div>
                <div class="detail detail-password">
                    <div class="detail-title">密码：</div>
                    <div class="detail-content">${map.password}</div>
                </div>
                <div class="detail detail-image">
                    <div class="detail-title">头像：</div>
                    <div class="detail-content">
                        <img src="${map.avatar}" style="width: 350px" />
                    </div>
                </div>
                <div class="detail detail-select">
                    <div class="detail-title">性别：</div>
                    <div class="detail-content">${map.gender}</div>
                </div>
                <div class="detail detail-longtext">
                    <div class="detail-title">地址：</div>
                    <div class="detail-content">${map.address}</div>
                </div>
            </div>

            <div class="button-list mt10">
                <div class="">
                    <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                    <button type="button" class="btn btn-default" onclick="window.print()">打印本页</button>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="foot.jsp" %>

