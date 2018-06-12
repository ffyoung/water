<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>
    <!-- Bootstrap -->
    <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/static/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
    <link href="/static/assets/styles.css" rel="stylesheet" media="screen">
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script src="/static/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>
<body id="login">
<div class="container">

    <form class="form-signin" id="formId">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input id="username" name="username" type="text" class="input-block-level" placeholder="Username">
        <input id="password" name="password" type="password" class="input-block-level" placeholder="Password">
        <button class="btn btn-large btn-primary" type="button" id="commit">Sign in</button>
    </form>

</div> <!-- /container -->
<script src="/static/js/jquery-1.9.1.min.js"></script>
<script src="/static/bootstrap/js/bootstrap.min.js"></script>


<script>

        $('#commit').click(function () {

            var username = $('#username').val();
            var password = $('#password').val();

            // 密码加载在这里更改
            var pswd = password;
            data = {password: pswd, username: username};
            $.ajax({
                url: "/user/main",
                data: data,
                type: "post",
                dataType: "json",
                success: function (result) {
                    if (result && result.status != 200) {
                        alert("账号密码错误!");
                        $('#password').val('');
                        return;
                    } else {
                        teem = result.teemId;
                        window.location.href ="index/"+teem;
                        setTimeout(function () {
                            //登录返回
                        }, 1000)
                    }
                }
            });
        });






</script>
</body>
</html>
