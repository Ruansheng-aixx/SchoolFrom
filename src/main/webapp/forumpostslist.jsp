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
            <h3 class="section-title">论坛列表</h3>
            <div class="sidebar-widget-body">
                <div class="">
                    <div style="margin-bottom: 20px">
                        <form action="?" class="search">
                            <table class="jd-search">
                                <tbody></tbody>
                            </table>
                        </form>

                        <form action="?" class="search">
                            <table class="jd-search">
                                <tbody>
                                    <tr>
                                        <td class="label1">分类</td>
                                        <td class="form-inline">
                                            <p class="search-radio">
                                                <input type="hidden" name="categorization" value="${param.categorization}" />
                                                <a href="javascript:;" data-value="" onclick="selectRadio(this)">全部</a>
                                                <ssm:sql var="mappostcategorization4" type="select"> SELECT id,categorizationname FROM postcategorization </ssm:sql>
                                                <c:forEach items="${mappostcategorization4}" var="r"
                                                    ><c:set var="r" value="${r}" scope="request" />
                                                    <a href="javascript:;" data-value="${r.id}" onclick="selectRadio(this)">${r.categorizationname}</a>
                                                </c:forEach>
                                            </p>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="label1">帖子名称</td>
                                        <td class="form-inline">
                                            <input
                                                type="text"
                                                class="form-control"
                                                style="width: 150px"
                                                name="postname"
                                                value="${param.postname}"
                                                placeholder="请输入关键词"
                                            />
                                            <button type="submit" class="btn btn-default">搜索</button>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>
                    <div class="news-list">
                        <ul>
                            <c:forEach items="${list}" var="r"
                                ><c:set var="r" value="${r}" scope="request" />
                                <li class="clearfix">
                                    <a href="forumpostsdetail.do?id=${r.id}">
                                        <div class="thumb">
                                            <div class="img-box pb100">
                                                <div class="img" style="background-image: url('${r.picture}')"></div>
                                            </div>
                                        </div>
                                    </a>

                                    <div class="news-content-text">
                                        <a href="forumpostsdetail.do?id=${r.id}">
                                            <h3>${r.postname}</h3>
                                        </a>
                                        <div class="description">${Info.subStr(r.postcontent, 80)}</div>
                                        <div class="other-content">
                                            <span
                                                >分类：<ssm:sql var="mappostcategorization5" type="find"> SELECT categorizationname,id FROM postcategorization where id='${r.categorization}' </ssm:sql
                                                >${mappostcategorization5.categorizationname}</span
                                            >
                                        </div>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
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

