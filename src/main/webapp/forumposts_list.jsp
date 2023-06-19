<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<%@page import="com.spring.util.*" %>
<%@page import="com.jntoo.db.*" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="head.jsp" %>


<div style="padding: 10px" class="admin-content">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="module-name"> 论坛帖子 </span>
            <span>列表</span>
        </div>
        <div class="panel-body">
            <div class="pa10 bg-warning">
                <form class="form-inline" id="formSearch" action="?">
                    <!-- form 标签开始 -->

                    <div class="form-group">
                        <i class="glyphicon glyphicon-search"></i>
                    </div>

                    <div class="form-group">
                        帖子编号

                        <input type="text" class="form-control" style="" name="postnumber"
                               value="${param.postnumber}"/>
                    </div>
                    <div class="form-group">
                        分类

                        <select class="form-control class_categorization1" data-value="${param.categorization}"
                                data-rule-required="true" data-msg-required="请填写分类" id="categorization" name="categorization">
                            <option value="">请选择</option>
                            <ssm:sql var="select" type="select"> SELECT * FROM postcategorization ORDER BY id desc </ssm:sql>
                            <c:forEach items="${select}" var="m"
                            ><c:set var="m" value="${m}" scope="request"/>
                                <option value="${m.id}">${m.categorizationname}</option>
                            </c:forEach>
                        </select>
                        <script>
                            $(".class_categorization1").val($(".class_categorization1").attr("data-value"));
                        </script>
                    </div>
                    <div class="form-group">
                        帖子名称

                        <input type="text" class="form-control" style="" name="postname"
                               value="${param.postname}"/>
                    </div>
                    <select class="form-control" name="order" id="orderby">
                        <option value="id">按发布时间</option>
                        <option value="postviews">按浏览量</option>
                    </select>
                    <select class="form-control" name="sort" id="sort">
                        <option value="desc">倒序</option>
                        <option value="asc">升序</option>
                    </select>
                    <script>
                        $("#orderby").val("${orderby}");
                        $("#sort").val("${sort}");
                    </script>
                    <button type="submit" class="btn btn-default">搜索</button>

                    <!--form标签结束-->
                </form>
            </div>

            <div class="list-table">
                <table width="100%" border="1" class="table table-list table-bordered table-hover">
                    <thead>
                    <tr align="center">
                        <th width="60" data-field="item">序号</th>
                        <th>帖子编号</th>
                        <th>分类</th>
                        <th>帖子名称</th>
                        <th>图片</th>
                        <th>发布时间</th>
                        <th>浏览量</th>
                        <th>发布人</th>
                        <th width="220" data-field="handler">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="i" value="0"/><c:forEach items="${list}" var="map"
                    ><c:set var="i" value="${i+1}"/><c:set var="map" value="${map}" scope="request"/>
                        <tr id="${map.id}" pid="">
                            <td width="30" align="center">
                                <label> ${i} </label>
                            </td>
                            <td>${map.postnumber}</td>
                            <td>
                                <ssm:sql var="mappostcategorization2"
                                         type="find"> SELECT categorizationname,id FROM postcategorization where id='${map.categorization}' </ssm:sql
                                >${mappostcategorization2.categorizationname}
                            </td>
                            <td>${map.postname}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${'' == map.picture }"> -</c:when><c:otherwise><img width="100"
                                                                                                     src="${map.picture}"/></c:otherwise
                                ></c:choose>
                            </td>
                            <td>${Info.subStr(map.releasetime , 19 , "")}</td>
                            <td>${map.postviews}</td>
                            <td>${map.publisher}</td>
                            <td align="center">


                                <a href="forumposts_detail.do?id=${map.id}">详情</a>

                                <a href="forumposts_updt.do?id=${map.id}">编辑</a>

                                <a href="forumposts_delete.do?id=${map.id}" onclick="return confirm('确定要删除？')">删除</a>
                                <!--qiatnalijne-->
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <%@include file="/page.jsp" %>

        </div>
    </div>
</div>
<%@ include file="foot.jsp" %>

