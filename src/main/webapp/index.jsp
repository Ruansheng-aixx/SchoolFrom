<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<%@page import="com.spring.util.*" %>
<%@page import="com.jntoo.db.*" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="head.jsp" %>
<%@ include file="header.jsp" %>


<link rel="stylesheet" href="js/swiper/swiper.css"/>
<script src="js/swiper/swiper.js"></script>

<div>
    <div class="container">
        <!-- 使用bootstrap css框架，container定宽，并剧中 https://v3.bootcss.com/css/#overview-container -->

        <div class="row">
            <div class="col-md-6">
                ${bhtList = Query.make("carouselmap").order("id desc").limit(3).select();""}

                <div class="swiper-container" id="base/banner22">
                    <div class="swiper-wrapper">
                        <c:forEach items="${bhtList}" var="bht"
                        ><c:set var="bht" value="${bht}" scope="request"/>
                            <div class="swiper-slide">
                                <div class="decoimg_b2">
                                    <a class="btn btn-" href="${bht.url}"
                                       style="background-image: url('${bht.image}'); height: 250px"></a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- 如果需要分页器 -->
                    <div class="swiper-pagination"></div>
                    <!-- 如果需要导航按钮 -->
                    <div class="swiper-button-prev"></div>
                    <div class="swiper-button-next"></div>
                </div>

                <script>
                    var mySwiper = new Swiper("#base/banner22", {
                        loop: true, // 循环模式选项
                        autoplay: {
                            delay: 3000,
                            disableOnInteraction: false,
                        },
                        // 如果需要分页器
                        pagination: {
                            el: ".swiper-pagination",
                        },
                        // 如果需要前进后退按钮
                        navigation: {
                            nextEl: ".swiper-button-next",
                            prevEl: ".swiper-button-prev",
                        },
                        // 如果需要滚动条
                        /*scrollbar: {
            el: '.swiper-scrollbar',
        },*/
                    });
                </script>
            </div>
            <div class="col-md-6">
                <div class="title-modelbox-widget">
                    <h3 class="section-title">
                        <div class="more">
                            <a href="announcementlist.do">更多&gt;&gt;</a>
                        </div>
                        公告
                    </h3>
                    <div class="sidebar-widget-body">
                        <div class="hotnews class1">
                            ${announcementlist26 = Query.make("announcement").limit(5).order("id desc").select();""}
                            <ul class="a">
                                <c:set var="i" value="0"/><c:forEach items="${announcementlist26}" var="r"
                            ><c:set var="i" value="${i+1}"/><c:set var="r" value="${r}" scope="request"/>
                                <li>
                                    <a href="announcementdetail.do?id=${r.id}" class="clearfix">
                                        <span class="shijian">${r.addtime}</span>
                                            ${r.announcementtitle}
                                    </a>
                                </li>
                            </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <!-- /.sidebar-widget-body -->
                </div>
            </div>
        </div>

        <!-- container定宽，并剧中结束 -->
    </div>
</div>

<div>
    <div class="container">
        <!-- 使用bootstrap css框架，container定宽，并剧中 https://v3.bootcss.com/css/#overview-container -->

        <div class="row">
            <div class="col-md-6">
                <div class="title-modelbox-widget">
                    <h3 class="section-title">
                        <div class="more">
                            <a href="forumpostslist.do">更多&gt;&gt;</a>
                        </div>
                        最新帖子
                    </h3>
                    <div class="sidebar-widget-body">
                        <div class="">
                            ${forumpostslist31 = Query.make("forumposts").limit(4).order("id desc").select();""}
                            <div class="news-list">
                                <ul>
                                    <c:forEach items="${forumpostslist31}" var="r"
                                    ><c:set var="r" value="${r}" scope="request"/>
                                        <li class="clearfix">
                                            <a href="forumpostsdetail.do?id=${r.id}">
                                                <div class="thumb">
                                                    <div class="img-box pb100">
                                                        <div class="img"
                                                             style="background-image: url('${r.picture}')"></div>
                                                    </div>
                                                </div>
                                            </a>

                                            <div class="news-content-text">
                                                <a href="forumpostsdetail.do?id=${r.id}">
                                                    <h3>${r.postname}</h3>
                                                </a>
                                                <div class="description">${Info.subStr(r.postcontent, 80)}</div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- /.sidebar-widget-body -->
                </div>
            </div>
            <div class="col-md-6">
                <div class="title-modelbox-widget">
                    <h3 class="section-title">
                        <div class="more">
                            <a href="forumpostslist.do">更多&gt;&gt;</a>
                        </div>
                        热门帖子
                    </h3>
                    <div class="sidebar-widget-body">
                        <div class="">
                            ${forumpostslist34 = Query.make("forumposts").limit(4).order("postviews desc").select();""}
                            <div class="news-list">
                                <ul>
                                    <c:forEach items="${forumpostslist34}" var="r"
                                    ><c:set var="r" value="${r}" scope="request"/>
                                        <li class="clearfix">
                                            <a href="forumpostsdetail.do?id=${r.id}">
                                                <div class="thumb">
                                                    <div class="img-box pb100">
                                                        <div class="img"
                                                             style="background-image: url('${r.picture}')"></div>
                                                    </div>
                                                </div>
                                            </a>

                                            <div class="news-content-text">
                                                <a href="forumpostsdetail.do?id=${r.id}">
                                                    <h3>${r.postname}</h3>
                                                </a>
                                                <div class="description">${Info.subStr(r.postcontent, 80)}</div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- /.sidebar-widget-body -->
                </div>
            </div>
        </div>

        <!-- container定宽，并剧中结束 -->
    </div>
</div>

<%@ include file="footer.jsp" %>
<%@ include file="foot.jsp" %>

