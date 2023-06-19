<%@ page language="java" pageEncoding="UTF-8" %>
 <%@ page language="java" import="java.util.*" %>
 <%@page import="com.spring.util.*" %>
 <%@page import="com.jntoo.db.*" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="head.jsp" %>
 <%@ include file="header.jsp" %>

<script src="js/jquery.validate.js"></script>
<link rel="stylesheet" href="js/layer/theme/default/layer.css" />
<script src="js/layer/layer.js"></script>

<div class="container">
    <!-- 使用bootstrap css框架，container定宽，并剧中 https://v3.bootcss.com/css/#overview-container -->

    <div class="panel panel-default">
        <div class="panel-heading">添加用户:</div>
        <div class="panel-body">
            <form action="userinsert.do" method="post" name="form1" id="form1">
                <!-- form 标签开始 -->

                <div class="form-group">
                    <div class="row">
                        <label style="text-align: right" class="col-sm-2 hiddex-xs">用户名<span style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <input
                                type="text"
                                class="form-control"
                                placeholder="输入用户名"
                                style="width: 150px"
                                data-rule-required="true"
                                data-msg-required="请填写用户名"
                                remote="checkno.do?checktype=insert&table=user&col=username"
                                data-msg-remote="内容重复了"
                                id="username"
                                name="username"
                                value=""
                            />
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <label style="text-align: right" class="col-sm-2 hiddex-xs">密码<span style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <input
                                type="password"
                                class="form-control"
                                placeholder="输入密码"
                                style="width: 150px"
                                data-rule-required="true"
                                data-msg-required="请填写密码"
                                id="password"
                                name="password"
                                value=""
                            />
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <label style="text-align: right" class="col-sm-2 hiddex-xs">头像</label>
                        <div class="col-sm-10">
                            <div class="input-group" style="width: 250px">
                                <input type="text" class="form-control" id="avatar" name="avatar" value="" />

                                <span class="input-group-btn"
                                    ><button
                                        type="button"
                                        class="btn btn-default"
                                        onclick="layer.open({type:2,title:'上传图片',fixed:true,shadeClose:true,shade:0.5,area:['320px','150px'],content:'upload.html?result=avatar'})"
                                    >
                                        上传图片
                                    </button></span
                                >
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <label style="text-align: right" class="col-sm-2 hiddex-xs">姓名<span style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <input
                                type="text"
                                class="form-control"
                                placeholder="输入姓名"
                                style="width: 150px"
                                data-rule-required="true"
                                data-msg-required="请填写姓名"
                                id="name"
                                name="name"
                                value=""
                            />
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <label style="text-align: right" class="col-sm-2 hiddex-xs">性别<span style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <select
                                class="form-control class_gender12"
                                data-value=""
                                data-rule-required="true"
                                data-msg-required="请填写性别"
                                id="gender"
                                name="gender"
                                style="width: 250px"
                            >
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <label style="text-align: right" class="col-sm-2 hiddex-xs">联系电话<span style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <input
                                type="text"
                                class="form-control"
                                placeholder="输入联系电话"
                                style="width: 150px"
                                data-rule-required="true"
                                data-msg-required="请填写联系电话"
                                phone="true"
                                data-msg-phone="请输入正确手机号码"
                                id="contactnumber"
                                name="contactnumber"
                                value=""
                            />
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <label style="text-align: right" class="col-sm-2 hiddex-xs">邮箱</label>
                        <div class="col-sm-10">
                            <input
                                type="text"
                                class="form-control"
                                placeholder="输入邮箱"
                                style="width: 150px"
                                email="true"
                                data-msg-email="请输入有效邮件地址"
                                id="mailbox"
                                name="mailbox"
                                value=""
                            />
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <label style="text-align: right" class="col-sm-2 hiddex-xs">地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" placeholder="输入地址" style="width: 250px" id="address" name="address" value="" />
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <label style="text-align: right" class="col-sm-2 hiddex-xs"> </label>
                        <div class="col-sm-10">
                            <button type="submit" class="btn btn-primary" name="Submit">提交</button>
                            <button type="reset" class="btn btn-default" name="Submit2">重置</button>
                        </div>
                    </div>
                </div>

                <!--form标签结束-->
            </form>
        </div>
    </div>

    <!-- container定宽，并剧中结束 -->
</div>

<script>
    $(function () {
        $("#form1").validate();
    });
</script>

<%@ include file="footer.jsp" %>
 <%@ include file="foot.jsp" %>

