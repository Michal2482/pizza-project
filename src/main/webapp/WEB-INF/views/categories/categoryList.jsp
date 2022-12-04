<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/css.jspf" %>
  <body>
  <%@include file="../dynamic/navigationMain.jspf" %>
    <!-- END nav -->

<%--    <section class="home-slider owl-carousel img" style="background-image: url(/resources/images/bg_1.jpg);">--%>

<%--      <div class="slider-item" style="background-image: url(/resources/images/bg_3.jpg);">--%>
<%--      	<div class="overlay"></div>--%>
<%--        <div class="container">--%>
<%--          <div class="row slider-text justify-content-center align-items-center">--%>

<%--            <div class="col-md-7 col-sm-12 text-center ftco-animate">--%>
<%--            	<h1 class="mb-3 mt-5 bread">Our Menu</h1>--%>
<%--	            <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Menu</span></p>--%>
<%--            </div>--%>

<%--          </div>--%>
<%--        </div>--%>
<%--      </div>--%>
<%--    </section>--%>
<%--    --%>
<%--		<section class="ftco-section">--%>
<%--    	<div class="container">--%>
<%--    		<div class="row justify-content-center mb-5 pb-3">--%>
<%--          <div class="col-md-7 heading-section ftco-animate text-center">--%>
<%--            <h2 class="mb-4">Our Menu</h2>--%>
<%--            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>--%>
<%--          </div>--%>
<%--        </div>--%>
<%--    	</div>--%>
<%--    	<div class="container-wrap">--%>
<%--    		<div class="row no-gutters d-flex">--%>
<%--				<c:forEach items="${meal}" var="title">--%>
<%--    			<div class="col-lg-4 d-flex ftco-animate">--%>
<%--    				<div class="services-wrap d-flex">--%>
<%--    					<a href='' class="img" style="background-image: url(/resources/images/pizza-1.jpg);"></a>--%>
<%--    					<div class="text p-4">--%>
<%--    						<h3>${title.name}</h3>--%>
<%--    						<p>${title.description}</p>--%>
<%--    						<p class="price"><span>${title.price}</span> <a href='' class="ml-2 btn btn-white btn-outline-white">Order</a></p>--%>
<%--    					</div>--%>
<%--    				</div>--%>
<%--    			</div>--%>
<%--				</c:forEach>--%>
<%--    			<div class="col-lg-4 d-flex ftco-animate">--%>
<%--    				<div class="services-wrap d-flex">--%>
<%--    					<a href="#" class="img" style="background-image: url(/resources/images/pizza-2.jpg);"></a>--%>
<%--    					<div class="text p-4">--%>
<%--    						<h3>Greek Pizza</h3>--%>
<%--    						<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia</p>--%>
<%--    						<p class="price"><span>$2.90</span> <a href="#" class="ml-2 btn btn-white btn-outline-white">Order</a></p>--%>
<%--    					</div>--%>
<%--    				</div>--%>
<%--    			</div>--%>
<%--    			<div class="col-lg-4 d-flex ftco-animate">--%>
<%--    				<div class="services-wrap d-flex">--%>
<%--    					<a href="#" class="img" style="background-image: url(/resources/images/pizza-3.jpg);"></a>--%>
<%--    					<div class="text p-4">--%>
<%--    						<h3>Caucasian Pizza</h3>--%>
<%--    						<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia</p>--%>
<%--    						<p class="price"><span>$2.90</span> <a href="#" class="ml-2 btn btn-white btn-outline-white">Order</a></p>--%>
<%--    					</div>--%>
<%--    				</div>--%>
<%--    			</div>--%>

<%--    			<div class="col-lg-4 d-flex ftco-animate">--%>
<%--    				<div class="services-wrap d-flex">--%>
<%--    					<a href="#" class="img order-lg-last" style="background-image: url(/resources/images/pizza-4.jpg);"></a>--%>
<%--    					<div class="text p-4">--%>
<%--    						<h3>American Pizza</h3>--%>
<%--    						<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia </p>--%>
<%--    						<p class="price"><span>$2.90</span> <a href="#" class="ml-2 btn btn-white btn-outline-white">Order</a></p>--%>
<%--    					</div>--%>
<%--    				</div>--%>
<%--    			</div>--%>
<%--    			<div class="col-lg-4 d-flex ftco-animate">--%>
<%--    				<div class="services-wrap d-flex">--%>
<%--    					<a href="#" class="img order-lg-last" style="background-image: url(/resources/images/pizza-5.jpg);"></a>--%>
<%--    					<div class="text p-4">--%>
<%--    						<h3>Tomatoe Pie</h3>--%>
<%--    						<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia</p>--%>
<%--    						<p class="price"><span>$2.90</span> <a href="#" class="ml-2 btn btn-white btn-outline-white">Order</a></p>--%>
<%--    					</div>--%>
<%--    				</div>--%>
<%--    			</div>--%>
<%--    			<div class="col-lg-4 d-flex ftco-animate">--%>
<%--    				<div class="services-wrap d-flex">--%>
<%--    					<a href="#" class="img order-lg-last" style="background-image: url(/resources/images/pizza-6.jpg);"></a>--%>
<%--    					<div class="text p-4">--%>
<%--    						<h3>Margherita</h3>--%>
<%--    						<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia</p>--%>
<%--    						<p class="price"><span>$2.90</span> <a href="#" class="ml-2 btn btn-white btn-outline-white">Order</a></p>--%>
<%--    					</div>--%>
<%--    				</div>--%>
<%--    			</div>--%>
<%--    		</div>--%>
<%--    	</div>--%>

  
    </section>

    <section class="ftco-menu">
    	<div class="container-fluid">
    		<div class="row d-md-flex">
				<c:forEach items="${category}" var="title1" >
<%--	    		<div class="col-lg-4 ftco-animate img f-menu-img mb-5 mb-md-0" style="background-image: url(/resources/images/about.jpg);">--%>
<%--	    		</div>--%>
	    		<div class="col-lg-8 ftco-animate p-md-5">
		    		<div class="row">
		          <div class="col-md-12 nav-link-wrap mb-5">
		            <div class="nav ftco-animate nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
<%--		              <a class="nav-link active" id="v-pills-1-tab" data-toggle="pill" href="#v-pills-1" role="tab" aria-controls="v-pills-1" aria-selected="true">Pizza</a>--%>

		              <a class="nav-link" id="v-pills-2-tab" data-toggle="pill" href="#v-pills-2" role="tab" aria-controls="v-pills-2" aria-selected="false">${title1.categoryName}</a>
					  <a href='<c:url value="/editCategory/" />' class="ml-2 btn btn-white btn-outline-white">Edytuj</a>

<%--		              <a class="nav-link" id="v-pills-3-tab" data-toggle="pill" href="#v-pills-3" role="tab" aria-controls="v-pills-3" aria-selected="false">Burgers</a>--%>

<%--		              <a class="nav-link" id="v-pills-4-tab" data-toggle="pill" href="#v-pills-4" role="tab" aria-controls="v-pills-4" aria-selected="false">Pasta</a>--%>
		            </div>
		          </div>
		          <div class="col-md-12 d-flex align-items-center">
		            
		            <div class="tab-content ftco-animate" id="v-pills-tabContent">

<%--		              <div class="tab-pane fade show active" id="v-pills-1" role="tabpanel" aria-labelledby="v-pills-1-tab">--%>
<%--		              	<div class="row">--%>
<%--		              		<div class="col-md-4 text-center">--%>
<%--		              			<div class="menu-wrap">--%>
<%--		              				<a href="#" class="menu-img img mb-4" style="background-image: url(/resources/images/pizza-1.jpg);"></a>--%>
<%--		              				<div class="text">--%>
<%--		              					<h3><a href="#">Itallian Pizza</a></h3>--%>
<%--		              					<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>--%>
<%--		              					<p class="price"><span>$2.90</span></p>--%>
<%--		              					<p><a href="#" class="btn btn-white btn-outline-white">Add to cart</a></p>--%>
<%--		              				</div>--%>
<%--		              			</div>--%>
<%--		              		</div>--%>
<%--		              		<div class="col-md-4 text-center">--%>
<%--		              			<div class="menu-wrap">--%>
<%--		              				<a href="#" class="menu-img img mb-4" style="background-image: url(/resources/images/pizza-2.jpg);"></a>--%>
<%--		              				<div class="text">--%>
<%--		              					<h3><a href="#">Itallian Pizza</a></h3>--%>
<%--		              					<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>--%>
<%--		              					<p class="price"><span>$2.90</span></p>--%>
<%--		              					<p><a href="#" class="btn btn-white btn-outline-white">Add to cart</a></p>--%>
<%--		              				</div>--%>
<%--		              			</div>--%>
<%--		              		</div>--%>
<%--		              		<div class="col-md-4 text-center">--%>
<%--		              			<div class="menu-wrap">--%>
<%--		              				<a href="#" class="menu-img img mb-4" style="background-image: url(/resources/images/pizza-3.jpg);"></a>--%>
<%--		              				<div class="text">--%>
<%--		              					<h3><a href="#">Itallian Pizza</a></h3>--%>
<%--		              					<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>--%>
<%--		              					<p class="price"><span>$2.90</span></p>--%>
<%--		              					<p><a href="#" class="btn btn-white btn-outline-white">Add to cart</a></p>--%>
<%--		              				</div>--%>
<%--		              			</div>--%>
<%--		              		</div>--%>
<%--		              	</div>--%>
<%--		              </div>--%>

<%--		              <div class="tab-pane fade" id="v-pills-2" role="tabpanel" aria-labelledby="v-pills-2-tab">--%>
<%--		                <div class="row">--%>
<%--		              		<div class="col-md-4 text-center">--%>
<%--		              			<div class="menu-wrap">--%>
<%--		              				<a href="#" class="menu-img img mb-4" style="background-image: url(/resources/images/drink-1.jpg);"></a>--%>
<%--		              				<div class="text">--%>
<%--		              					<h3><a href="#">Lemonade Juice</a></h3>--%>
<%--		              					<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>--%>
<%--		              					<p class="price"><span>$2.90</span></p>--%>
<%--		              					<p><a href="#" class="btn btn-white btn-outline-white">Add to cart</a></p>--%>
<%--		              				</div>--%>
<%--		              			</div>--%>
<%--		              		</div>--%>
<%--		              		<div class="col-md-4 text-center">--%>
<%--		              			<div class="menu-wrap">--%>
<%--		              				<a href="#" class="menu-img img mb-4" style="background-image: url(/resources/images/drink-2.jpg);"></a>--%>
<%--		              				<div class="text">--%>
<%--		              					<h3><a href="#">Pineapple Juice</a></h3>--%>
<%--		              					<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>--%>
<%--		              					<p class="price"><span>$2.90</span></p>--%>
<%--		              					<p><a href="#" class="btn btn-white btn-outline-white">Add to cart</a></p>--%>
<%--		              				</div>--%>
<%--		              			</div>--%>
<%--		              		</div>--%>
<%--		              		<div class="col-md-4 text-center">--%>
<%--		              			<div class="menu-wrap">--%>
<%--		              				<a href="#" class="menu-img img mb-4" style="background-image: url(/resources/images/drink-3.jpg);"></a>--%>
<%--		              				<div class="text">--%>
<%--		              					<h3><a href="#">Soda Drinks</a></h3>--%>
<%--		              					<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>--%>
<%--		              					<p class="price"><span>$2.90</span></p>--%>
<%--		              					<p><a href="#" class="btn btn-white btn-outline-white">Add to cart</a></p>--%>
<%--		              				</div>--%>
<%--		              			</div>--%>
<%--		              		</div>--%>
		              	</div>
		              </div>

<%--		              <div class="tab-pane fade" id="v-pills-3" role="tabpanel" aria-labelledby="v-pills-3-tab">--%>
<%--		                <div class="row">--%>
<%--		              		<div class="col-md-4 text-center">--%>
<%--		              			<div class="menu-wrap">--%>
<%--		              				<a href="#" class="menu-img img mb-4" style="background-image: url(/resources/images/burger-1.jpg);"></a>--%>
<%--		              				<div class="text">--%>
<%--		              					<h3><a href="#">Itallian Pizza</a></h3>--%>
<%--		              					<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>--%>
<%--		              					<p class="price"><span>$2.90</span></p>--%>
<%--		              					<p><a href="#" class="btn btn-white btn-outline-white">Add to cart</a></p>--%>
<%--		              				</div>--%>
<%--		              			</div>--%>
<%--		              		</div>--%>
<%--		              		<div class="col-md-4 text-center">--%>
<%--		              			<div class="menu-wrap">--%>
<%--		              				<a href="#" class="menu-img img mb-4" style="background-image: url(/resources/images/burger-2.jpg);"></a>--%>
<%--		              				<div class="text">--%>
<%--		              					<h3><a href="#">Itallian Pizza</a></h3>--%>
<%--		              					<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>--%>
<%--		              					<p class="price"><span>$2.90</span></p>--%>
<%--		              					<p><a href="#" class="btn btn-white btn-outline-white">Add to cart</a></p>--%>
<%--		              				</div>--%>
<%--		              			</div>--%>
<%--		              		</div>--%>
<%--		              		<div class="col-md-4 text-center">--%>
<%--		              			<div class="menu-wrap">--%>
<%--		              				<a href="#" class="menu-img img mb-4" style="background-image: url(/resources/images/burger-3.jpg);"></a>--%>
<%--		              				<div class="text">--%>
<%--		              					<h3><a href="#">Itallian Pizza</a></h3>--%>
<%--		              					<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>--%>
<%--		              					<p class="price"><span>$2.90</span></p>--%>
<%--		              					<p><a href="#" class="btn btn-white btn-outline-white">Add to cart</a></p>--%>
<%--		              				</div>--%>
<%--		              			</div>--%>
<%--		              		</div>--%>
		              	</div>
		              </div>

<%--		              <div class="tab-pane fade" id="v-pills-4" role="tabpanel" aria-labelledby="v-pills-4-tab">--%>
<%--		                <div class="row">--%>
<%--		              		<div class="col-md-4 text-center">--%>
<%--		              			<div class="menu-wrap">--%>
<%--		              				<a href="#" class="menu-img img mb-4" style="background-image: url(/resources/images/pasta-1.jpg);"></a>--%>
<%--		              				<div class="text">--%>
<%--		              					<h3><a href="#">Itallian Pizza</a></h3>--%>
<%--		              					<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>--%>
<%--		              					<p class="price"><span>$2.90</span></p>--%>
<%--		              					<p><a href="#" class="btn btn-white btn-outline-white">Add to cart</a></p>--%>
<%--		              				</div>--%>
<%--		              			</div>--%>
<%--		              		</div>--%>
<%--		              		<div class="col-md-4 text-center">--%>
<%--		              			<div class="menu-wrap">--%>
<%--		              				<a href="#" class="menu-img img mb-4" style="background-image: url(/resources/images/pasta-2.jpg);"></a>--%>
<%--		              				<div class="text">--%>
<%--		              					<h3><a href="#">Itallian Pizza</a></h3>--%>
<%--		              					<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>--%>
<%--		              					<p class="price"><span>$2.90</span></p>--%>
<%--		              					<p><a href="#" class="btn btn-white btn-outline-white">Add to cart</a></p>--%>
<%--		              				</div>--%>
<%--		              			</div>--%>
<%--		              		</div>--%>
<%--		              		<div class="col-md-4 text-center">--%>
<%--		              			<div class="menu-wrap">--%>
<%--		              				<a href="#" class="menu-img img mb-4" style="background-image: url(/resources/images/pasta-3.jpg);"></a>--%>
<%--		              				<div class="text">--%>
<%--		              					<h3><a href="#">Itallian Pizza</a></h3>--%>
<%--		              					<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>--%>
<%--		              					<p class="price"><span>$2.90</span></p>--%>
<%--		              					<p><a href="#" class="btn btn-white btn-outline-white">Add to cart</a></p>--%>
<%--		              				</div>--%>
<%--		              			</div>--%>
<%--		              		</div>--%>
<%--		              	</div>--%>
<%--		              </div>--%>
		            </div>
		          </div>
		        </div>
		      </div>
		</c:forEach>
		    </div>
    	</div>
    </section>

<%--    <%@include file="../dynamic/board.jspf" %>--%>

	<%@include file="../dynamic/javaScript.jspf" %>
    
  </body>
</html>