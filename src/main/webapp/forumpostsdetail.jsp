<%@ page language="java" pageEncoding="UTF-8" %>
 <%@ page language="java" import="java.util.*" %>
 <%@page import="com.spring.util.*" %>
 <%@page import="com.jntoo.db.*" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="head.jsp" %>
 <%@ include file="header.jsp" %>

<link rel="stylesheet" href="js/umeditor/themes/default/css/umeditor.css" />
<script src="js/umeditor/umeditor.config.js"></script>
<script src="js/umeditor/umeditor.min.js"></script>

<div>
    <div class="container">
        <!-- 使用bootstrap css框架，container定宽，并剧中 https://v3.bootcss.com/css/#overview-container -->

        <div class="title-modelbox-widget">
            <h3 class="section-title">详情</h3>
            <div class="sidebar-widget-body">
                <div class="detail-bbs">
                    <div class="read_t">
                        <table width="100%" class="floot">
                            <tbody>
                                <tr class="vt">
                                    <td rowspan="2" class="floot_left">
                                        <div class="readName b">
                                            <a href="javascript:;"> ${user = Query.make("user").where("username", map.publisher).find();""} ${user.name} </a>
                                        </div>
                                        <div class="floot_leftdiv">
                                            <a href="javascript:;" class="userCard face_img">
                                                <c:choose>
                                                    <c:when test="${user.avatar == null || '' == user.avatar }">
                                                        <img class="pic" src="images/default.gif" width="120" height="120" border="0" /> </c:when
                                                    ><c:otherwise>
                                                        <img class="pic" src="${user.avatar}" width="120" height="120" border="0" /> </c:otherwise
                                                ></c:choose>
                                            </a>
                                            <div class="readUser_info cc mb10">
                                                <div class="one" id="basic_info_2920754"></div>
                                            </div>
                                            <div></div>
                                        </div>
                                    </td>
                                    <td class="floot_right">
                                        <a name="post_2920754"></a>
                                        <!--印戳-->
                                        <!--楼层信息及编辑-->
                                        <div class="tipTop s6"><a class="s2 b cp">楼主</a> </div>
                                        <div class="read_h1" style="margin-bottom: 10px" id="subject_2920754">${map.postname}</div>
                                        <div class="tpc_content">
                                            <div class="f14 mb10">${map.postcontent}</div>
                                        </div>
                                        <!--content_read-->
                                    </td>
                                </tr>
                                <tr>
                                    <td class="floot_bottom">
                                        <!--评分-->
                                        <div id="w_2920754" class="c"></div>
                                        <!--评分结束-->
                                        <div class="tipBottom cc" data-index="-1">
                                            <!--<div class="fl readbot">
                            <a class="r-reply" title="回复楼主" href="javascript:;" onclick="postreply('回 7楼(陈正奇) 的帖子');">回复</a>
                        </div>-->
                                            <!--<div class="fr">
                            <a title="举报此帖" href="javascript:;" class="mr5">举报</a>
                        </div>-->
                                            <c:choose>
                                                <c:when test="${sessionScope.username != null && '' !=  sessionScope.username }">
                                                    ${collectionsCount = Query.make("collections").where("biao", "").where("xwid", map.id).where("username",
                                                    sessionScope.username).field("count(*) as count").find();""}
                                                    <c:choose>
                                                        <c:when test="${collectionsCount.count !=  '0'  }">
                                                            <button
                                                                type="button"
                                                                class="btn btn-default"
                                                                onclick="location.href='collectionsinsert.do?xwid=${map.id}&biao=forumposts&biaoti=${map.postname}'"
                                                            >
                                                                取消收藏
                                                            </button> </c:when
                                                        ><c:otherwise>
                                                            <button
                                                                type="button"
                                                                class="btn btn-default"
                                                                onclick="location.href='collectionsinsert.do?xwid=${map.id}&biao=forumposts&biaoti=${map.postname}'"
                                                            >
                                                                收藏
                                                            </button>
                                                        </c:otherwise></c:choose
                                                    > </c:when
                                                ><c:otherwise>
                                                    <button
                                                        type="button"
                                                        class="btn btn-default"
                                                        onclick="location.href='collectionsinsert.do?xwid=${map.id}&biao=forumposts&biaoti=${map.postname}'"
                                                    >
                                                        收藏
                                                    </button>
                                                </c:otherwise></c:choose
                                            >
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <table width="100%" class="flootbg">
                        <tbody>
                            <tr>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>

                    <script>
                        var page = "${param.page}";
                        if (page == "" || page == "null") {
                            page = 1;
                        }
                        var pagesize = 10;
                        page = Math.max(Math.floor(page), 1);
                        var index = (page - 1) * pagesize + 1;
                    </script>

                    ${list = Query.make("postreplies").where("forumpostid", map.id).order("id asc").page(10);""}
                    <c:set var="i" value="0" /><c:forEach items="${list}" var="reply"
                        ><c:set var="i" value="${i+1}" /><c:set var="reply" value="${reply}" scope="request" />
                        <div class="">
                            <div class="read_t">
                                <table width="100%" class="floot">
                                    <tbody>
                                        <tr class="vt">
                                            <td rowspan="2" class="floot_left">
                                                <div class="readName b">
                                                    <a href="javascript:;"> ${user = Query.make("user").where("username", reply.replypeople).find();""} ${user.name} </a>
                                                </div>
                                                <div class="floot_leftdiv">
                                                    <a href="javascript:;" class="userCard face_img">
                                                        <c:choose>
                                                            <c:when test="${user.avatar == null || '' == user.avatar }">
                                                                <img class="pic" src="images/default.gif" width="120" height="120" border="0" /> </c:when
                                                            ><c:otherwise>
                                                                <img class="pic" src="${user.avatar}" width="120" height="120" border="0" /> </c:otherwise
                                                        ></c:choose>
                                                    </a>

                                                    <div class="readUser_info cc mb10">
                                                        <div class="one" id="basic_info_2920754"></div>
                                                    </div>
                                                </div>
                                            </td>
                                            <td class="floot_right" id="td_2920754">
                                                <!--印戳-->
                                                <!--楼层信息及编辑-->
                                                <div class="tipTop s6">
                                                    <a class="s2 b cp"
                                                        >#
                                                        <script>
                                                            document.write(index);
                                                        </script>
                                                        楼</a
                                                    > 
                                                </div>
                                                <div class="tpc_content">
                                                    <div class="f14 mb10">${reply.replycontent}</div>
                                                </div>
                                                <!--content_read-->
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="floot_bottom">
                                                <!--评分-->
                                                <div id="w_2920754" class="c"></div>
                                                <!--评分结束-->
                                                <div class="tipBottom cc">
                                                    <div class="fl readbot">
                                                        <a class="r-reply" title="回复此楼" href="javascript:;" onclick="postreply(this);">回复</a>
                                                        <div style="display: none">
                                                            <p>
                                                                回【
                                                                <script>
                                                                    document.write(index);
                                                                </script>
                                                                楼】（${user.name}）的帖子
                                                            </p>
                                                            ${reply.replycontent}
                                                        </div>
                                                    </div>
                                                    <!--<div class="fr">
                                <a title="举报此帖" href="javascript:;" class="mr5">举报</a>
                            </div>-->
                                                </div>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <table width="100%" class="flootbg">
                                <tbody>
                                    <tr>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <script>
                            index++;
                        </script>
                    </c:forEach>
                    <div class=""><%@include file="/page.jsp" %>
</div>
                    <div class="t" style="padding: 0; margin-bottom: 0">
                        <form name="FORM" method="post" action="postrepliesinsert.do" id="anchor">
                            <div class="b h" style="border-top: 0">快速回复</div>
                            <table width="100%" class="floot" style="table-layout: inherit">
                                <tbody>
                                    <tr class="vt">
                                        <td class="floot_left">
                                            <div class="floot_leftdiv">
                                                <div>
                                                    <p class="b">${sessionScope.name}</p>
                                                </div>
                                                <div class="cc">
                                                    <c:choose>
                                                        <c:when test="${sessionScope.avatar == null || '' == sessionScope.avatar }">
                                                            <div class="face_img"><img class="pic" src="images/default.gif" width="120" height="120" border="0" /></div> </c:when
                                                        ><c:otherwise>
                                                            <div class="face_img">
                                                                <img class="pic" src="${sessionScope.avatar}" width="120" height="120" border="0" />
                                                            </div> </c:otherwise
                                                    ></c:choose>
                                                </div>
                                            </div>
                                        </td>
                                        <td style="padding: 10px 0 10px 10px">
                                            <div class="c mb10">
                                                <div class="" style="display: none">
                                                    ${readMap = Query.make("forumposts").where("id", param.id).find();""}

                                                    <input type="hidden" name="forumpostid" value="${param.id}" />
                                                    <input type="hidden" id="postnumber" name="postnumber" value="${Info.html(readMap.postnumber)}" />
                                                    <input type="hidden" id="categorization" name="categorization" value="${Info.html(readMap.categorization)}" />
                                                    <input type="hidden" id="postname" name="postname" value="${Info.html(readMap.postname)}" />
                                                    <input type="hidden" id="publisher" name="publisher" value="${Info.html(readMap.publisher)}" />
                                                    <input
                                                        type="text"
                                                        class="form-control"
                                                        placeholder="输入回复人"
                                                        style="width: 150px"
                                                        readonly="readonly"
                                                        id="replypeople"
                                                        name="replypeople"
                                                        value="${sessionScope.username}"
                                                    />
                                                </div>
                                                <input name="referer" id="referer" value="" type="hidden" />
                                                <script>
                                                    $("#referer").val(location.href);
                                                </script>

                                                <textarea id="replycontent" style="width: 100%; height: 120px" name="replycontent"></textarea>
                                            </div>
                                            <div>
                                                <span class="mr20">
                                                    <span class="bt" style="margin: 0">
                                                        <span>
                                                            <button type="submit" class="btn btn-primary" name="Submit">发 布</button>
                                                        </span>
                                                    </span>
                                                </span>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                        <script>
                            function stripscript(s) {
                                return s.replace(/<script.*?>.*?<\/script>/gis, "");
                            }
                            function postreply(obj) {
                                var content = stripscript($(obj).next().html());
                                content = content.replace(/【(.*?)([0-9]+)(.*?)】/gis, function ($0, $1, $2) {
                                    return "【" + $2 + "楼】";
                                });
                                content = "<blockquote>" + content + "</blockquote><p>&nbsp;</p>";
                                var editor = UM.getEditor("replycontent");
                                editor.setContent(content);
                                $(window).scrollTop(99999);
                                editor.focus();
                            }
                            UM.getEditor("replycontent");
                        </script>
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

