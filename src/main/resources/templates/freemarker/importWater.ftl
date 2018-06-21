<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>数据导入</title>
    <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/static/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
    <link href="/static/assets/styles.css" rel="stylesheet" media="screen">
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script src="/static/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <script type="text/javascript">
        //JS校验form表单信息
        function checkData() {
            var fileDir = $("#upfile").val();
            var suffix = fileDir.substr(fileDir.lastIndexOf("."));
            if ("" == fileDir) {
                alert("选择需要导入的Excel文件！");
                return false;
            }
            if (".xls" != suffix && ".xlsx" != suffix) {
                alert("选择Excel格式的文件导入！");
                return false;
            }
            return true;
        }
    </script>
</head>

<body>
<h3>数据导入</h3>
<div>
    <form method="POST" enctype="multipart/form-data" id="form1" action="/water/excel">
        <label>上传文件: </label>
        <input id="upfile" type="file" name="upfile"><br> <br>
        <input type="submit" value="上传提交" onclick="return checkData()">
    </form>
</div>
<div id="complete"></div>

<script src="/static/js/jquery-1.9.1.min.js"></script>
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
