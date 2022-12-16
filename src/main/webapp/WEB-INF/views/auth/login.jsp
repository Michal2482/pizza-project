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
        
                <div class="card o-hidden border-0 shadow-lg my-5">
                  <div class="card-body p-0" >
                    <!-- Nested Row within Card Body -->
                    <div class="row  d-flex justify-content-center align-items-center">
                      <div class="col-lg-5 d-none d-lg-block"><img src="/resources/images/pizza_login.png" class="img-fluid" alt=""></div>
                      <div class="col-lg-7">
                        <div class="p-5">
                          <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Welcome !</h1>
                          </div>
                          <form class="user" method="post" action='<c:url value="/login"/>'>
                            <div class="form-group h4">
                              <input type="text" class="form-control" name="username" placeholder="Username">
                            </div>

                            <div class="form-group">
                              <input type="password" class="form-control" name="password" id="exampleInputPassword" placeholder="Password">
                            </div>
                  
                            <div class="form-group">
                              <div class="custom-control custom-checkbox small">
                                <input type="checkbox" class="custom-control-input" id="customCheck">
                                <label class="custom-control-label" for="customCheck">Remeber me!</label>
                              </div>
                            </div>
                            <input type="submit" value="Login" class="btn btn-primary btn-user btn-block">
                          </form>
                          <div class="text-center">
                            <a class="small" href='<c:url value="/register"/>'>Create account</a>
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
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

  <%@include file="../dynamic/javaScript.jspf" %>
    
  </body>
</html>