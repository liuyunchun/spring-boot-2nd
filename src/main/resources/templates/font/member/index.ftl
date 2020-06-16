<!DOCTYPE html>
<html lang="en">

<!-- Basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Site Metas -->
<title>Forest Time - Stylish Magazine Blog Template</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">

<!-- Site Icons -->
<link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon" />
<link rel="apple-touch-icon" href="/images/apple-touch-icon.png">

<!-- Design fonts -->
<link href="https://fonts.googleapis.com/css?family=Droid+Sans:400,700" rel="stylesheet">

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.css" rel="stylesheet">

<!-- FontAwesome Icons core CSS -->
<link href="/css/font-awesome.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/style.css" rel="stylesheet">

<!-- Responsive styles for this template -->
<link href="/css/responsive.css" rel="stylesheet">

<!-- Colors for this template -->
<link href="/css/colors.css" rel="stylesheet">

<!-- Version Garden CSS for this template -->
<link href="/css/version/garden.css" rel="stylesheet">

<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

</head>
<body>

<div id="wrapper">
    <div class="collapse top-search" id="collapseExample">
        <div class="card card-block">
            <div class="newsletter-widget text-center">
                <form class="form-inline">
                    <input type="text" class="form-control" placeholder="What you are looking for?">
                    <button type="submit" class="btn btn-primary"><i class="fa fa-search"></i></button>
                </form>
            </div><!-- end newsletter -->
        </div>
    </div><!-- end top-search -->

    <div class="topbar-section">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-4 col-md-6 col-sm-6 hidden-xs-down">
                    <div class="topsocial">
                        <a href="#" data-toggle="tooltip" data-placement="bottom" title="Facebook"><i class="fa fa-facebook"></i></a>
                        <a href="#" data-toggle="tooltip" data-placement="bottom" title="Youtube"><i class="fa fa-youtube"></i></a>
                        <a href="#" data-toggle="tooltip" data-placement="bottom" title="Pinterest"><i class="fa fa-pinterest"></i></a>
                        <a href="#" data-toggle="tooltip" data-placement="bottom" title="Twitter"><i class="fa fa-twitter"></i></a>
                        <a href="#" data-toggle="tooltip" data-placement="bottom" title="Flickr"><i class="fa fa-flickr"></i></a>
                        <a href="#" data-toggle="tooltip" data-placement="bottom" title="Instagram"><i class="fa fa-instagram"></i></a>
                        <a href="#" data-toggle="tooltip" data-placement="bottom" title="Google+"><i class="fa fa-google-plus"></i></a>
                    </div><!-- end social -->
                </div><!-- end col -->

                <div class="col-lg-4 hidden-md-down">
                </div><!-- end col -->

                <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
                    <div class="topsearch text-right">
                        <a data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample"><i class="fa fa-search"></i> Search</a>
                    </div><!-- end search -->
                </div><!-- end col -->
            </div><!-- end row -->
        </div><!-- end header-logo -->
    </div><!-- end topbar -->

    <div class="header-section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="logo">
                        <a href="/index"><img src="images/version/garden-logo.png" alt=""></a>
                    </div><!-- end logo -->
                </div>
            </div><!-- end row -->
        </div><!-- end header-logo -->
    </div><!-- end header -->

    <header class="header">
        <div class="container">
            <nav class="navbar navbar-inverse navbar-toggleable-md">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#Forest Timemenu" aria-controls="Forest Timemenu" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-md-center" id="Forest Timemenu">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link color-green-hover" href="/index">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link color-green-hover" href="/category">Gardening</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link color-green-hover" href="/category">Outdoor Living</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link color-green-hover" href="/category">Indoor Living</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link color-green-hover" href="/category">Shopping Guides</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div><!-- end container -->
    </header><!-- end header -->


    <section class="section wb">
        <div class="container">
            <div class="row">
                <form method="get" action="/member/find-syscode">
                    id:
                    <input type="text" name="id"/>
                <#--<br>-->
                <#--name:-->
                <#--<input type="text" name="name"/>-->
                <#--<br>-->
                <#--email:-->
                <#--<input type="text" name="email"/>-->
                    <button type="submit" class="btn btn-default" name="find" value="find">查詢</button>

                    <a href="/member/add" class="btn btn-default" name="add" value="add">新增</a>
                </form>
                <table class="table" >
                    <tr>
                        <td>
                            ID
                        </td>
                        <td>
                            暱稱
                        </td>
                        <td>
                            信箱
                        </td>
                        <td>
                            功能
                        </td>
                    </tr>
                    <#list members as item>
                        <tr>
                            <td>
                                ${item.id}
                            </td>
                            <td>
                                ${item.name}
                            </td>
                            <td>
                                ${item.email}
                            </td>
                            <td>
                                <a href="/member/update?id=${item.id}" class="btn btn-default" name="update" >修改</a>

                                <a href="/member/delete?id=${item.id}" class="btn btn-primary" name="delete" >刪除</a>
                            </td>
                        </tr>
                    </#list>
                </table>
            </div><!-- end row -->
        </div><!-- end container -->
    </section>

    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 offset-lg-2">
                    <div class="widget">
                        <div class="footer-text text-center">
                            <a href="/index"><img src="images/version/garden-footer-logo.png" alt="" class="img-fluid"></a>
                            <p>Forest Time is a personal blog for handcrafted, cameramade photography content, fashion styles from independent creatives around the world.</p>
                            <div class="social">
                                <a href="#" data-toggle="tooltip" data-placement="bottom" title="Facebook"><i class="fa fa-facebook"></i></a>
                                <a href="#" data-toggle="tooltip" data-placement="bottom" title="Twitter"><i class="fa fa-twitter"></i></a>
                                <a href="#" data-toggle="tooltip" data-placement="bottom" title="Instagram"><i class="fa fa-instagram"></i></a>
                                <a href="#" data-toggle="tooltip" data-placement="bottom" title="Google Plus"><i class="fa fa-google-plus"></i></a>
                                <a href="#" data-toggle="tooltip" data-placement="bottom" title="Pinterest"><i class="fa fa-pinterest"></i></a>
                            </div>

                            <hr class="invis">

                            <div class="newsletter-widget text-center">
                                <form class="form-inline">
                                    <input type="text" class="form-control" placeholder="Enter your email address">
                                    <button type="submit" class="btn btn-primary">Subscribe <i class="fa fa-envelope-open-o"></i></button>
                                </form>
                            </div><!-- end newsletter -->
                        </div><!-- end footer-text -->
                    </div><!-- end widget -->
                </div><!-- end col -->
            </div>
            <div class="row">
                <div class="col-md-12 text-center">
                    <br>
                    <br>
                    <div class="copyright">&copy; Forest Time. Design: <a href="http://html.design">HTML Design</a>.</div>
                </div>
            </div>
        </div><!-- end container -->
    </footer><!-- end footer -->

    <div class="dmtop">Scroll to Top</div>

</div><!-- end wrapper -->

<!-- Core JavaScript
================================================== -->
<script src="js/jquery.min.js"></script>
<script src="js/tether.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/custom.js"></script>

</body>
</html>