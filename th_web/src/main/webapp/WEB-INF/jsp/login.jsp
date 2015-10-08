<%@ page pageEncoding="utf-8" contentType="text/html; UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>ThinkWeb | 用户登录</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.5 -->
  <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/resources/dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="/resources/plugins/iCheck/square/blue.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="/resources/assert/js/html5shiv/html5shiv.min-3.7.3.js"></script>
  <script src="/resources/assert/js/respond/respond.min-1.4.2.js"></script>
  <![endif]-->
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="/"><b>Think</b>CAT</a>
  </div><!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg"> 让体验与众不同 </p>
    <form action="login" method="post">
      <div class="form-group has-feedback">
        <input type="text" id="th-username" class="form-control" name="username" placeholder="User">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" id="th-password" class="form-control" name="password" placeholder="Password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div>
            <label>
              <input id="rmbUser" type="checkbox"> 记住我的账号
            </label>
          </div>
        </div><!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" onclick="saveUserInfo()" class="btn btn-primary btn-block btn-flat">登录</button>
        </div><!-- /.col -->
      </div>
    </form>

    <a href="#">喔... 忘记密码了?</a><br>
    <a href="register.html" class="text-center">注册一个新的账号</a>

  </div><!-- /.login-box-body -->
</div><!-- /.login-box -->

<!-- jQuery 2.1.4 -->
<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- jquery cookie -->
<script src="/resources/plugins/jQuery/jquery.cookie.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="/resources/plugins/iCheck/icheck.min.js"></script>
<script>
//  $(function () {
//    $('input').iCheck({
//      checkboxClass: 'icheckbox_square-blue',
//      radioClass: 'iradio_square-blue',
//      increaseArea: '20%' // optional
//    });
//  });

  //remember account
  $(document).ready(function(){
    if ($.cookie("rmbUser") == "true") {
      $("#rmbUser").attr("checked", true);
      $("#th-username").val($.cookie("userName"));
      $("#th-password").val($.cookie("passWord"));
    }
  });

  function saveUserInfo() {
    if ($("#rmbUser").is(':checked')) {
      var userName = $("#th-username").val();
      var passWord = $("#th-password").val();
      $.cookie("rmbUser", "true", { expires: 7 }); // 存储一个带7天期限的 cookie
      $.cookie("userName", userName, { expires: 7 }); // 存储一个带7天期限的 cookie
      $.cookie("passWord", passWord, { expires: 7 }); // 存储一个带7天期限的 cookie
    }
    else {
      $.cookie("rmbUser", "false", { expires: -1 });        // 删除 cookie
      $.cookie("userName", '', { expires: -1 });
      $.cookie("passWord", '', { expires: -1 });
    }
  }

</script>
</body>
</html>
