<%--
  Created by IntelliJ IDEA.
  User: juepei
  Date: 2015/10/14
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main>

    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            权限管理
            <small>编辑您的权限信息</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li class="active"> 权限管理</li>
        </ol>
    </section>

    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <!-- Custom Tabs -->
                <div class="nav-tabs-custom">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#tab_1" data-toggle="tab">用户</a></li>
                        <li><a href="#tab_2" data-toggle="tab">角色</a></li>
                        <li><a href="#tab_3" data-toggle="tab">权限</a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="tab_1">

                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="box">
                                        <!-- /.box-header -->
                                        <div class="box-body table-responsive no-padding">
                                            <table class="table table-hover">
                                                <tr>
                                                    <th>ID</th>
                                                    <th>用户名</th>
                                                    <th>所属角色</th>
                                                    <th>用户类型</th>
                                                    <th>最后登录时间</th>
                                                    <th>操作</th>
                                                </tr>
                                                <tr>
                                                    <td>1</td>
                                                    <td>ThinkCat</td>
                                                    <td>管理员</td>
                                                    <td>管理员</td>
                                                    <td>2015-10-14</td>
                                                    <td>
                                                        <a class="label label-success">编辑</a>
                                                        <a class="label label-danger">删除</a>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                        <!-- /.box-body -->
                                    </div>
                                    <!-- /.box -->
                                </div>
                            </div>

                        </div>
                        <!-- /.tab-pane -->
                        <div class="tab-pane" id="tab_2">
                            <%--TODO--%>
                            角色信息
                        </div>
                        <!-- /.tab-pane -->
                        <div class="tab-pane" id="tab_3">
                            <%--TODO--%>
                           权限信息
                        </div>
                        <!-- /.tab-pane -->
                    </div>
                    <!-- /.tab-content -->
                </div>
                <!-- nav-tabs-custom -->
            </div>
            <!-- /.col -->
        </div>
    </section>

    <!-- Main content -->
    <section class="content">

    </section>

</t:main>
