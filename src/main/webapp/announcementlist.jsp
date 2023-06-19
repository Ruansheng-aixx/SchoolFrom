<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<%@page import="com.spring.util.*" %>
<%@page import="com.jntoo.db.*" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="head.jsp" %>
<%@ include file="header.jsp" %>


<div>
    <div class="container">
        <!-- 使用bootstrap css框架，container定宽，并剧中 https://v3.bootcss.com/css/#overview-container -->

        <div class="title-modelbox-widget">
            <h3 class="section-title">公告列表</h3>
            <div class="sidebar-widget-body">
                <div class="hotnews class1">
                    <div style="margin-bottom: 20px">
                        <div class="pa10 bg-warning">
                            <form class="form-inline" action="?">
                                <!-- form 标签开始 -->

                                <div class="form-group">
                                    <i class="glyphicon glyphicon-search"></i>
                                </div>

                                <div class="form-group">
                                    公告编号

                                    <input type="text" class="form-control" style="" name="announcementnumber"
                                           value="${param.announcementnumber}"/>
                                </div>
                                <div class="form-group">
                                    公告标题

                                    <input type="text" class="form-control" style="" name="announcementtitle"
                                           value="${param.announcementtitle}"/>
                                </div>

                                <select class="form-control" name="order" id="orderby">
                                    <option value="id">按发布时间</option>
                                </select>
                                <select class="form-control" name="sort" id="sort">
                                    <option value="desc">倒序</option>
                                    <option value="asc">升序</option>
                                </select>
                                <script>
                                    $("#orderby").val("${orderby}");
                                    $("#sort").val("${sort}");
                                </script>
                                <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i>
                                    搜索
                                </button>

                                <!--form标签结束-->
                            </form>
                        </div>
                    </div>
                    <ul class="a">
                        <c:set var="i" value="0"/><c:forEach items="${list}" var="r"
                    ><c:set var="i" value="${i+1}"/><c:set var="r" value="${r}" scope="request"/>
                        <li>
                            <a href="announcementdetail.do?id=${r.id}" class="clearfix">
                                <span class="shijian">${r.releasedate}</span>
                                    ${r.announcementtitle}
                            </a>
                        </li>
                    </c:forEach>
                    </ul>
                    <%@include file="/page.jsp" %>

                </div>
            </div>
            <!-- /.sidebar-widget-body -->
        </div>

        <!-- container定宽，并剧中结束 -->
    </div>
</div>

<%@ include file="footer.jsp" %>
<%@ include file="foot.jsp" %>

