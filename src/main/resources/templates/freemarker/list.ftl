<#assign path= request.contextPath>
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
                        <a href="index"><i class="icon-chevron-right"></i>水位流量页</a>
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
                            <div class="muted"><h2 align="center">河南省信阳市平桥区老鸭河灌区1001001断面水位与流量对应关系表</h2></div>
                        </div>
                        <div class="col-md-5 col-sm-5 col-xs-12 form-group  top_search">
                            <form action="/water/list" method="get">
                            <div class="input-group">
                                <input style="height: auto;width: 150px" type="text" class="form-control" placeholder="小数点保留三位" name="waterDepth"
                                       value="${waterDepth?default('')}" id="waterDepth" />
                                <span class="input-group-btn">
                                    <input class="btn btn-default" type="submit">Go!</input>
                                </span>
                            </div>

                        <div class="block-content collapse in">
                            <div class="span12" id="edit_area_div">

                                <table class="table" border="1">
                                    <thead>
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
                                    <#if waterlist?size gt 0>
                                    <#list waterlist as list>
                                    <tr>
                                        <td>${(currentPage-1)*15+list_index+1}</td>
                                        <td>${list.water_depth}</td>
                                        <td>${list.flow}</td>
                                        <td>${list.area}</td>
                                        <td>${list.volicity}</td>
                                        <td>${list.remark?default("")}</td>
                                    </tr>
                                    </#list>
                                    </#if>
                                    </tbody>
                                </table>

                            <div class="message">
                                    当前第 ${list.pageNum} 页.总共 ${list.pages} 页.一共 ${list.total} 条记录
                                </div>
                            <div id="complete">@@@@@@@@@@@@@@@@@@</div>
                            </form>
                                <#--<div class="col-md-6" align="center">-->
                                    <#--<nav aria-label="Page navigation">-->
                                        <#--<ul class="pagination">-->

                                            <#--<li><a href="${path}/water/list?pageNow=1">首页</a></li>-->
                                            <#--<li>-->
                                                <#--<#if list.hasPreviousPage>-->
                                                    <#--<a href="${path}/water/list?pageNow=${list.pageNum-1}" aria-label="Previous">-->
                                                        <#--<span aria-hidden="true">上一页</span>-->
                                                    <#--</a>-->
                                                <#--</#if>-->
                                            <#--</li>-->
                                            <#--<#list list.navigatepageNums as page_num>-->
                                                <#--<#if page_num == list.pageNum>-->
                                                    <#--<li class="active"><a href="#">${page_num}</a></li>-->
                                                <#--</#if>-->
                                                <#--<#if page_num != list.pageNum>-->
                                                    <#--<li><a href="${path}/water/list?pageNow=${page_num}">${page_num}</a></li>-->
                                                <#--</#if>-->
                                            <#--</#list>-->
                                            <#--<!--下一页&ndash;&gt;-->
                                            <#--<li>-->
                                                <#--<#if list.hasNextPage>-->
                                                    <#--<a href="${path}/water/list?pageNow=${list.pageNum+1}"-->
                                                       <#--aria-label="Next">-->
                                                        <#--<span aria-hidden="true">下一页</span>-->
                                                    <#--</a>-->
                                                <#--</#if>-->
                                            <#--</li>-->

                                            <#--<li><a href="${path}/water/list?pageNow=${list.pages}">尾页</a></li>-->
                                        <#--</ul>-->
                                    <#--</nav>-->
                                <#--</div>-->
                            </div>
                        </div
                    </div>
                    <!-- /block -->
                </div>
            </div>
        </div>
        <hr>
    </div>
    <!--/.fluid-container-->




        <!--/.fluid-container-->
        <script src="/static/js/jquery-1.9.1.min.js"></script>
        <script src="/static/bootstrap/js/bootstrap.min.js"></script>
        <script src="/static/js/jquery.easy-pie-chart.js"></script>
        <script src="/static/js/pageDo.js"></script>
        <script>
        $(function() {
            // Easy pie charts
            $('.chart').easyPieChart({animate: 1000});
        });
        </script>
    </body>
<style>
    li{display: inline}
</style>
<script>
    $(function () {
        PagingManage($('#complete'),${totalPage},${pageSize},${currentPage});
    });
    function pageDo(page){
        var wd = $("#waterDepth").val();
        var url = "/water/list?pageNow="+page+"&waterDepth="+wd;
        window.location.href = url;
    }
</script>
</html>