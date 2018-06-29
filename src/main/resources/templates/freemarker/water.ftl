<!DOCTYPE html>
<html class="no-js">

<head>
    <title>乾元</title>
    <!-- Bootstrap -->
    <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/static/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
    <link href="/static/css/jquery.easy-pie-chart.css" rel="stylesheet" media="screen">
    <link href="/static/assets/styles.css" rel="stylesheet" media="screen">
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script src="/static/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <style>
        .table thead th{
            text-align:center;
            vertical-align: middle !important;
        }
        .table tbody tr td{
            text-align:center;
        }
        #complete ul li{
            display:inline;
            margin-left:15px;
        }
    </style>
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
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> <i class="icon-user"></i> Vincent Gabriel <i class="caret"></i>

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
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">Content <i class="caret"></i>

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
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">Users <i class="caret"></i>

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
        <div class="span9" id="content">
            <div class="row-fluid">
                <!-- block -->
                <div class="block">
                    <div class="navbar navbar-inner block-header">
                        <div style="font-size: large;text-align: center;">
                            河南省信阳市平桥区老鸭河灌区1001001断面水位与流量对应关系表
                        </div>
                    </div>
                    <div class="block-content collapse in">
                        <div class="span12">
                            <table class="table" border="1">
                            <tr>
                                <th>断面编号：</th>
                                <th>1001001</th>
                                <th>最大水深：</th>
                                <th>3000MM</th>
                                <th>最大流量：</th>
                                <th>5.000M³/S</th>
                            </tr>
                            <tr>
                                <th>对比断面编号：</th>
                                <th>${conum}</th>
                                <th>断面间距：</th>
                                <th>25M</th>
                                <th>断面面积：</th>
                                <th>5.500M²</th>
                            </tr>
                            <tr>
                                <th rowspan="2">序号</th>
                                <th>断面水深H</th>
                                <th>修正流量Q</th>
                                <th>过水面积S</th>
                                <th>平均流速V</th>
                                <th rowspan="2">操作</th>
                                <th rowspan="2">备注</th>
                            </tr>
                            <tr>
                                <th>(MM)</th>
                                <th>(M³/S)</th>
                                <th>（M²）</th>
                                <th>（M/S)</th>
                            </tr>
                                </thead>
                                <tbody>
                                    <#list waterlist as list>
                                    <tr>
                                        <td>${list.id}</td>
                                        <td>${list.water_depth}</td>
                                        <td>${list.flow}</td>
                                        <td>${list.area}</td>
                                        <td>${list.volicity}</td>
                                        <td><a href="javascript:updateMsg(${list.id})" + class="btn btn-default"">编辑</a></td>
                                        <td>${list.remark?default("")}</td>
                                    </tr>
                                    </#list>
                                </tbody>
                            </table>
                        </div>
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
<#--///-->
<script>
    $(function() {
        // Easy pie charts
        $('.chart').easyPieChart({animate: 1000});
    });


    /*更改信息页面跳转*/
    function updateMsg(id) {
        var url = "/water/updateDo/"+id;
        window.location.href = url;
    }
</script>
</body>

</html>