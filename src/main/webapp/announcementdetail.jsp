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
            <h3 class="section-title">详情</h3>
            <div class="sidebar-widget-body">
                <div>
                    <div class="common-title" style="margin-top: 4em">
                        <p>
                            <i></i>
                            <i></i>
                        </p>
                    </div>
                    <div class="news_show">
                        <span class="show_t"> ${map.announcementtitle} </span>
                        <span class="fa_time"> 发布日期:${map.releasedate}    发布人:${map.publisher}    </span>

                        <div>${map.announcementcontent}</div>
                        <div class="s_x clearfix">
                            <ssm:sql var="prev" type="find"> SELECT * FROM announcement WHERE id<'${map.id}' ORDER BY id desc </ssm:sql>
                            <c:choose>
                                <c:when test="${prev.id != null}">
                                    <a href="announcementdetail.do?id=${prev.id}" class="s_prev">上一篇：${prev.announcementtitle}</a> </c:when
                                ><c:otherwise>
                                    <a href="javascript:;" class="s_prev">上一篇：没有了</a>
                                </c:otherwise></c:choose
                            >
                            <ssm:sql var="next" type="find"> SELECT * FROM announcement WHERE id>'${map.id}' ORDER BY id asc </ssm:sql>
                            <c:choose>
                                <c:when test="${next.id != null}">
                                    <a href="announcementdetail.do?id=${next.id}">下一篇：${next.announcementtitle}</a> </c:when
                                ><c:otherwise>
                                    <a href="javascript:;">下一篇：没有了</a>
                                </c:otherwise></c:choose
                            >
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.sidebar-widget-body -->
        </div>

        <!-- container定宽，并剧中结束 -->
    </div>
</div>

<%@ include file="footer.jsp" %>
 <%@ include file="foot.jsp" %>

