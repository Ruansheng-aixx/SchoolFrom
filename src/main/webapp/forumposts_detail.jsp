<%@ page language="java" pageEncoding="UTF-8" %>
 <%@ page language="java" import="java.util.*" %>
 <%@page import="com.spring.util.*" %>
 <%@page import="com.jntoo.db.*" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="head.jsp" %>


<div style="padding: 10px" class="admin-content">
    <div class="panel panel-default">
        <div class="panel-heading">论坛帖子详情</div>
        <div class="panel-body">
            <div class="admin-detail clearfix">
                <div class="detail detail-text">
                    <div class="detail-title">帖子编号：</div>
                    <div class="detail-content">${map.postnumber}</div>
                </div>
                <div class="detail detail-select">
                    <div class="detail-title">分类：</div>
                    <div class="detail-content">
                        <ssm:sql var="mappostcategorization6" type="find"> SELECT categorizationname,id FROM postcategorization where id='${map.categorization}' </ssm:sql>${mappostcategorization6.categorizationname}
                    </div>
                </div>
                <div class="detail detail-longtext">
                    <div class="detail-title">帖子名称：</div>
                    <div class="detail-content">${map.postname}</div>
                </div>
                <div class="detail detail-image">
                    <div class="detail-title">图片：</div>
                    <div class="detail-content">
                        <img src="${map.picture}" style="width: 350px" />
                    </div>
                </div>
                <div class="detail detail-autotime">
                    <div class="detail-title">发布时间：</div>
                    <div class="detail-content">${map.releasetime}</div>
                </div>
                <div class="detail detail-number">
                    <div class="detail-title">浏览量：</div>
                    <div class="detail-content">${map.postviews}</div>
                </div>
                <div class="detail detail-textuser">
                    <div class="detail-title">发布人：</div>
                    <div class="detail-content">${map.publisher}</div>
                </div>
                <div class="detail detail-editor">
                    <div class="detail-title">帖子内容：</div>
                    <div class="detail-content">${map.postcontent}</div>
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

