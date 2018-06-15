<!DOCTYPE html>
<html class="no-js">

    <head>
        <title>Admin Home Page</title>
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
                        <a href="index"><i class="icon-chevron-right"></i>流量页</a>
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
                            <div class="muted pull-left">流量表</div>
                        </div>
                        <div class="block-content collapse in">
                            <div class="span12">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>时间T1</th>
                                        <th>时间T2</th>
                                        <th>水位H1（米）</th>
                                        <th>水位H2（米）</th>
                                        <th>流量Q1（立方米每小时）</th>
                                        <th>流量Q2（立方米每小时）</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <#list wfList as list>
                                    <tr>
                                        <td>${list_index+1}</td>
                                        <td>${list.lastDate?string("yyyy-MM-dd hh:mm:ss")}</td>
                                        <td>${list.newDate?string("yyyy-MM-dd hh:mm:ss")}</td>
                                        <td>${list.topHight}</td>
                                        <td>${list.bottomHight}</td>
                                        <td>${list.flow}</td>
                                        <td>${list.totalFlow}</td>
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
    <!--/.fluid-container-->




        <!--/.fluid-container-->
        <script src="/static/js/jquery-1.9.1.min.js"></script>
        <script src="/static/bootstrap/js/bootstrap.min.js"></script>
        <script src="/static/js/jquery.easy-pie-chart.js"></script>
        <script src="/static/assets/scripts.js"></script>
        <script>
        $(function() {
            // Easy pie charts
            $('.chart').easyPieChart({animate: 1000});
        });
        </script>
    </body>

</html>