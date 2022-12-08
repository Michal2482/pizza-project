<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/css.jspf" %>

<body>
<%@include file="../dynamic/navigationMainAuth.jspf" %>

<section class="home-slider owl-carousel img" style="background-image: url(/resources/images/bg_1.jpg);">

    <div class="slider-item" style="background-image: url(/resources/images/bg_3.jpg);">
        <div class="overlay"></div>
        <div class="container">

            <!-- Outer Row -->
            <div class="row justify-content-center">

                <div class="col-xl-10 col-lg-12 col-md-9">

                    <div class="card-auth o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row d-flex justify-content-center align-items-center">
                            <div class="col-lg-5  d-lg-block"><img src="/resources/images/pizza_register.png" class="img-fluid" alt=""></div>
                            <div class="col-lg-7">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Register now!</h1>
                                    </div>
                                    <form class="user">
                                        <div class="form-group">

                                            <input type="text" class="form-control form-control-user"
                                                   id="exampleFirstName" placeholder="Username">

                                        </div>
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user"
                                                   id="exampleInputEmail" placeholder="email">
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <input type="password" class="form-control form-control-user"
                                                       id="exampleInputPassword" placeholder="Password">
                                            </div>
                                            <div class="form-group row">
                                                <input type="password" class="form-control form-control-user"
                                                       id="exampleRepeatPassword" placeholder="Confirm Password ">
                                            </div>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" id="exampleRepeatPassword"
                                                       placeholder="Prefix">
                                            </div>
                                        </div>
                                        <a href="login.html" class="btn btn-primary btn-user btn-block">
                                            Register
                                        </a>
                                        <hr>

                                    </form>
                                    <div class="text-center">
                                        <a class="small" href='<c:url value="/login"/>'>Do you have account? Log in</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>
    </div>
    </div>
</section>


<!-- loader -->
<div id="ftco-loader" class="show fullscreen">
    <svg class="circular" width="48px" height="48px">
        <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/>
        <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
                stroke="#F96D00"/>
    </svg>
</div>

<%@include file="../dynamic/javaScript.jspf" %>

</body>
</html>