<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/css.jspf" %>
  <body>
  <%@include file="../dynamic/navigationMain.jspf" %>
    <!-- END nav -->

    <section class="home-slider owl-carousel img" style="background-image: url(/resources/images/bg_1.jpg);">

      <div class="slider-item" style="background-image: url(/resources/images/bg_3.jpg);">
      	<div class="overlay"></div>
        <div class="container">
          <div class="row slider-text justify-content-center align-items-center">

            <div class="col-md-7 col-sm-12 text-center ftco-animate">
            	<h1 class="mb-3 mt-5 bread">Our Menu</h1>
	            <p class="breadcrumbs"><span class="mr-2"><a href='<c:url value="/${prefix}"/>'>Home</a></span> <span>Menu</span></p>
            </div>

          </div>
        </div>
      </div>
    </section>
    
		<section class="ftco-section">
    	<div class="container">
    		<div class="row justify-content-center mb-5 pb-3">
          <div class="col-md-7 heading-section ftco-animate text-center">
            <h2 class="mb-4">Our Menu</h2>
            <p>${descriptionOnPages.shortDescriptionMenuPage}</p>
          </div>
        </div>
    	</div>
    	<div class="container-wrap">
    		<div class="row no-gutters d-flex">
				<c:forEach items="${meal}" var="category">
    			<div class="col-lg-4 d-flex ftco-animate">
    				<div class="services-wrap d-flex">
    					<a href='' class="img" style="background-image: url(/resources/images/pizza-1.jpg);"></a>
    					<div class="text p-4">
    						<h3>${category.name}</h3>
    						<p>${category.description}</p>
    						<p class="price"><span>${category.price}</span> <a href='' class="ml-2 btn btn-white btn-outline-white">Order</a></p>
    					</div>
    				</div>
    			</div>
				</c:forEach>
    		</div>
    	</div>

  
    </section>

<section class="ftco-menu">
    <div class="container-fluid">
        <div class="row d-md-flex">
            <div class="col-lg-4 ftco-animate img f-menu-img mb-5 mb-md-0"
                 style="background-image: url(/resources/images/about.jpg);">
            </div>
            <div class="col-lg-8 ftco-animate p-md-5">
                <div class="row">
                    <div class="col-md-12 nav-link-wrap mb-5">
                        <div class="nav ftco-animate nav-pills" id="v-pills-tab" role="tablist"
                             aria-orientation="vertical">
                            <c:forEach items="${category}" var="title" varStatus="loop">
                                <a class="nav-link '<c:if test="${loop.index==0}"> active show</c:if>'"
                                   id="${'v-pills-'.concat(loop.index+1).concat("-tab")}" data-toggle="pill"
                                   href='#v-pills-${loop.index+1}' role="tab"
                                   aria-controls="${'v-pills-'.concat(loop.index+1)}"
                                   aria-selected='<c:if test="${loop.index==0}">true</c:if>'
                                   <c:if test="${loop.index!=0}">false</c:if> >${title.categoryName}</a>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="col-md-12 d-flex align-items-center">
                        <div class="tab-content ftco-animate" id="v-pills-tabContent">
                            <c:forEach items="${categoryMap}" var="entry" varStatus="loop">
                                <div class="tab-pane fade <c:if test="${loop.index == 0}">show active</c:if>"
                                     id="${'v-pills-'.concat(loop.index+1)}" role="tabpanel"
                                     aria-labelledby="v-pills-1-tab">

                                    <div class="row">
                                        <c:forEach items="${entry.value}" var="menuElement">
                                            <div class="d-flex justify-content-between">
                                                <div class="col-4">
                                                    <div class="menu-wrap">
                                                        <a href='<c:url value="/addOrder/${menuElement.id}"/>'
                                                           class="menu-img img mb-4"
                                                           style="background-image: url(/resources/images/pizza-1.jpg);"></a>
                                                        <div class="text">
                                                            <h3><a href="#">${menuElement.name}</a></h3>
                                                            <p>${menuElement.description}</p>
                                                            <p class="price"><span>${menuElement.price}</span></p>
                                                            <p>
                                                                <a href='<c:url value="/${prefix}/order/add"><c:param name="mealId" value="${menuElement.id}"/></c:url>'
                                                                   class="btn btn-white btn-outline-white">Add
                                                                    to cart</a></p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>

                                </div>
                            </c:forEach>


                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

    <%@include file="../dynamic/board.jspf" %>

	<%@include file="../dynamic/javaScript.jspf" %>
    
  </body>
</html>