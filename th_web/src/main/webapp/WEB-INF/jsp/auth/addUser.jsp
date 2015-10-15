<%--
  Created by IntelliJ IDEA.
  User: juepei
  Date: 2015/10/15
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:main>
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            新增用户
        </h1>
        <ol class="breadcrumb">
            <li><a href="/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="/auth"><i class="fa fa-edit"></i> 用户权限</a></li>
            <li class="active"> 增加用户</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">

        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="register-box" style="width: 60%">
                    <!-- Custom Tabs -->
                        <form action="/user/addUser" method="post" class="form-horizontal" style="width: 70%;align-items: center">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="userName" class="form-control" id="inputEmail3" placeholder="用户名">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                                    <div class="col-sm-10">
                                        <input type="password" name="password" class="form-control" id="inputPassword3"
                                               placeholder="密码">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="role" class="col-sm-2 control-label" style="float: left">角色</label>
                                    <div class="col-sm-10">
                                        <select class="form-control  select2 " name="roleId" id="role" style="float: right" >
                                            <option value="3" selected="selected">Alabama</option>
                                            <option value="1">Alaska</option>
                                            <option value="2">California</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer"  >
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                <button type="submit" class="btn btn-default  ">取消</button>
                                <button type="submit" class="btn btn-success pull-right">确定</button>
                            </div>
                            <!-- /.box-footer -->
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- /.content -->
</t:main>
