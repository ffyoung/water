<!DOCTYPE html>
<html class="no-js">

<head>
    <title>乾元</title>
    <!-- Bootstrap -->
    <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/static/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
    <link href="/static/css/jquery.easy-pie-chart.css" rel="stylesheet" media="screen">
    <link href="/static/assets/styles.css" rel="stylesheet" media="screen">
    <link href="/static/js/layer.css" rel="stylesheet" media="screen">
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script src="/static/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>

<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">Admin Panel</a>
            <div class="nav-collapse collapse">
                <ul class="nav pull-right">
                    <li class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> <i
                                class="icon-user"></i> Vincent Gabriel <i class="caret"></i>

                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a tabindex="-1" href="#">Profile</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a tabindex="-1" href="">Logout</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav">
                    <li class="active">
                        <a href="#">Dashboard</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Settings <b class="caret"></b>

                        </a>
                        <ul class="dropdown-menu" id="menu1">
                            <li>
                                <a href="#">Tools <i class="icon-arrow-right"></i>

                                </a>
                                <ul class="dropdown-menu sub-menu">
                                    <li>
                                        <a href="#">Reports</a>
                                    </li>
                                    <li>
                                        <a href="#">Logs</a>
                                    </li>
                                    <li>
                                        <a href="#">Errors</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">SEO Settings</a>
                            </li>
                            <li>
                                <a href="#">Other Link</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">Other Link</a>
                            </li>
                            <li>
                                <a href="#">Other Link</a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">Content <i
                                class="caret"></i>

                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a tabindex="-1" href="#">Blog</a>
                            </li>
                            <li>
                                <a tabindex="-1" href="#">News</a>
                            </li>
                            <li>
                                <a tabindex="-1" href="#">Custom Pages</a>
                            </li>
                            <li>
                                <a tabindex="-1" href="#">Calendar</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a tabindex="-1" href="#">FAQ</a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">Users <i
                                class="caret"></i>

                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a tabindex="-1" href="#">User List</a>
                            </li>
                            <li>
                                <a tabindex="-1" href="#">Search</a>
                            </li>
                            <li>
                                <a tabindex="-1" href="#">Permissions</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span3" id="sidebar">
            <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
                <li>
                    <a href="index"><i class="icon-chevron-right"></i>水位流量表</a>
                </li>
                <li>
                    <a href="#"><span class="badge badge-success pull-right">123</span> Logs</a>
                </li>
            </ul>
        </div>
        <!--/span-->
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>水位修改 <small>数据修改</small></h2>
                    </div>
                    <div class="clearfix"></div>
                    <div class="block-content collapse in">
                        <form id="waterform" class="form-horizontal container" method="post" role="form">
                            <div class="form-group" hidden>
                                <label for="control-label">id</label>
                                <div class="col-sm-10">
                                <input type="text" class="form-control" id="id" name="id" value="${water.id}">
                                </div>
                                </div>
                            <div class="form-group container">
                                <label for="control-label" class="col-md-6 control-label container">断面水深H: </label>
                                <div class="col-sm-10">
                                <input type="text" class="form-control" id="water_depth" name="water_depth" value="${water.water_depth}" readonly>
                            </div>
                            </div>
                            <br>
                            <div class="form-group container">
                                <label for="control-label" class="col-sm-2 control-label">修正流量Q: </label>
                                <div class="col-sm-10">
                                <input type="text" class="form-control" id="flow" name="flow" value="${water.flow}">
                            </div>
                            </div>
                            <br>
                            <div class="form-group container">
                                <label for="control-label" class="col-sm-2 control-label">过水面积S: </label>
                                <div class="col-sm-10">
                                <input type="text" class="form-control" id="area" name="area" value="${water.area}">
                            </div>
                            </div>
                            <br>
                            <div class="form-group container">
                                    <label for="control-label" class="col-sm-2 control-label">平均流速: </label>
                                <div class="col-sm-10">
                                <input type="text" class="form-control" id="volicity" name="volicity" value="${water.volicity}">
                            </div>
                            </div>
                            <br>
                            <div class="form-group container">
                                <label for="control-label" class="col-sm-2 control-label">备注: </label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="remark" name="remark" value="${water.remark}">
                                </div>
                            </div>
                            <br>
                            <div class="form-group container">
                                <label for="control-label" class="col-sm-2 control-label"></label>
                                <div class="col-sm-10">
                                    <button type="button" id="btn"  class="btn btn-success">修改</button>
                                </div>
                            </div>
                            <#--<div class="center-block">-->
                            <#--<button type="button" id="btn"  class="btn btn-success">修改</button>-->
                            <#--</div>-->
                        </form>
                    </div>
                </div>
                <!-- /block -->
            </div>
        </div>
    </div>
    <hr>
    <footer>
        <p>&copy; Bili Yan 2018 - More TT <a href="#" target="_blank" title="cssmoban">V_V</a>
    </footer>
</div>
<script src="/static/js/jquery-1.9.1.min.js"></script>
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<script src="/static/js/jquery.easy-pie-chart.js"></script>
<script src="/static/assets/scripts.js"></script>
<#--分页-->
<script src="/static/js/pageDo.js"></script>
<script src="/static/js/layer.js"></script>
<script>
    $(function () {
        // Easy pie charts
        $('.chart').easyPieChart({animate: 1000});
    });

    jQuery(document).ready(
            $("#btn").click(function () {
                var from = $("#waterform");
                var inputs = $("form :text");
                var inlength = inputs.length;
                for (var i = 0; i < inlength; i++) {
                    var self = $(inputs[i]);
                    if (self.val() == '') {
                        self.focus();
                        return layer.msg("信息不能为空", function () {
                        }), !1;
                    }
                }

                var load = layer.load();
                $.post("/water/updateWater", $("#waterform").serialize(), function (result) {
                    layer.close(load);
                    if (result && result.status != 200) {
                        return layer.msg(result.message, function () {
                        }), !1;
                    } else {
                        layer.msg('修改成功!');
                        setTimeout(function () {
                            window.location.href = "/water/list?pageNow=" + 1;
                        }, 2000);
                    }
                }, "json");
            })
    )
</script>

</body>
</html>