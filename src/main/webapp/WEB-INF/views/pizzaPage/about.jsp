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
                    <h1 class="mb-3 mt-5 bread">About</h1>
                    <p class="breadcrumbs"><span class="mr-2"><a href='<c:url value="/${prefix}"/>'>Home</a></span>
                        <span>About</span></p>
                </div>

            </div>
        </div>
    </div>
</section>


<section class="ftco-intro">
    <div class="container-wrap">
        <div class="wrap d-md-flex">
            <div class="info">
                <div class="row no-gutters">
                    <div class="col-md-3 d-flex ftco-animate">
                        <div class="icon"><span class="icon-phone"></span></div>
                        <div class="text">
                            <h3>${basicInformation.propertyNumber}</h3>
                            <p>${basicInformation.shortDescriptionPizzeria}</p>
                        </div>
                    </div>
                    <div class="col-md-3 d-flex ftco-animate">
                        <div class="icon"><span class="icon-my_location"></span></div>
                        <div class="text">
                            <h3>${basicInformation.zipCode} ${basicInformation.city}</h3>
                            <p>${basicInformation.street} ${basicInformation.propertyNumber}</p>
                        </div>
                    </div>
                    <div class="col-md-6 d-flex ftco-animate">
                        <div class="icon"><span class="icon-clock-o"></span></div>
                        <div class="text">
                            <h3>Open Hours:</h3>
                            <div class="row">
                                <div class="col-6">
                                    <p>Mon: <fmt:formatDate value="${basicInformation.openHoursMondayFrom}"
                                                            pattern="HH:mm"/>-<fmt:formatDate
                                            value="${basicInformation.openHoursMondayTo}" pattern="HH:mm"/></p>
                                    <p>Tue: <fmt:formatDate value="${basicInformation.openHoursTuesdayFrom}"
                                                            pattern="HH:mm"/>-<fmt:formatDate
                                            value="${basicInformation.openHoursTuesdayTo}" pattern="HH:mm"/></p>
                                    <p>Wed: <fmt:formatDate value="${basicInformation.openHoursWednesdayFrom}"
                                                            pattern="HH:mm"/>-<fmt:formatDate
                                            value="${basicInformation.openHoursWednesdayTo}" pattern="HH:mm"/></p>
                                    <p>Thu: <fmt:formatDate value="${basicInformation.openHoursThursdayFrom}"
                                                            pattern="HH:mm"/>-<fmt:formatDate
                                            value="${basicInformation.openHoursThursdayTo}" pattern="HH:mm"/></p>
                                </div>
                                <div class="col-6">
                                    <p>Fri: <fmt:formatDate value="${basicInformation.openHoursFridayFrom}"
                                                            pattern="HH:mm"/>-<fmt:formatDate
                                            value="${basicInformation.openHoursFridayTo}" pattern="HH:mm"/></p>
                                    <p>Sat: <fmt:formatDate value="${basicInformation.openHoursSaturdayFrom}"
                                                            pattern="HH:mm"/>-<fmt:formatDate
                                            value="${basicInformation.openHoursSaturdayTo}" pattern="HH:mm"/></p>
                                    <p>Sun: <fmt:formatDate value="${basicInformation.openHoursSundayFrom}"
                                                            pattern="HH:mm"/>-<fmt:formatDate
                                            value="${basicInformation.openHoursSundayTo}" pattern="HH:mm"/></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="social d-md-flex pl-md-5 p-4 align-items-center">
                <ul class="social-icon d-md-flex flex-column">
                    <li class="ftco-animate py-3"><a href="${basicInformation.twitterUrl}" target="_blank"><span
                            class="icon-twitter"></span></a></li>
                    <li class="ftco-animate py-3"><a href="${basicInformation.facebookUrl}" target="blank"><span
                            class="icon-facebook"></span></a></li>
                    <li class="ftco-animate py-3"><a href="${basicInformation.instagramUrl}"><span
                            class="icon-instagram"></span></a></li>
                </ul>
            </div>
        </div>
    </div>
</section>

<section class="ftco-about d-md-flex">
    <div class="one-half img" style="background-image: url(/resources/images/about.jpg);"></div>
    <div class="one-half ftco-animate">
        <div class="heading-section ftco-animate ">
            <h2 class="mb-4">Welcome to <span class="flaticon-pizza">${basicInformation.firstPartName} ${basicInformation.secondPartName}</span> A Restaurant</h2>
        </div>
        <div>
            <p>${descriptionOnPages.longDescriptionHomePage}</p>
        </div>
    </div>
</section>

<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center mb-5 pb-3">
            <div class="col-md-7 heading-section ftco-animate text-center">
                <h2 class="mb-4">Our Chef</h2>
                <p class="flip"><span class="deg1"></span><span class="deg2"></span><span class="deg3"></span></p>
                <p class="mt-5">${descriptionOnPages.shortDescriptionMenuPage}</p>
            </div>
        </div>
        <div class="row">
			<c:forEach items="${person}" var="category">
				<div class="col-lg-3 d-flex mb-sm-4 ftco-animate">
					<div class="staff">
						<div class="img mb-4" style="background-image: url(/resources/images/person_1.jpg);"></div>
						<div class="info text-center">
							<h3><a href="teacher-single.html">${category.name}</a></h3>
								<%--      					<span class="position">${title.function}</span>--%>
							<div class="text">
								<p>${category.description}</p>
							</div>
							</div>
					</div>
				</div>
			</c:forEach>
<%--        	<div class="col-lg-3 d-flex mb-sm-4 ftco-animate">--%>
<%--        		<div class="staff">--%>
<%--      				<div class="img mb-4" style="background-image: url(/resources/images/person_1.jpg);"></div>--%>
<%--      				<div class="info text-center">--%>
<%--      					<h3><a href="teacher-single.html">Tom Smith</a></h3>--%>
<%--      					<span class="position">Hair Specialist</span>--%>
<%--      					<div class="text">--%>
<%--	        				<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>--%>
<%--	        			</div>--%>
<%--      				</div>--%>
<%--        		</div>--%>
<%--        	</div>--%>
<%--        	<div class="col-lg-3 d-flex mb-sm-4 ftco-animate">--%>
<%--        		<div class="staff">--%>
<%--      				<div class="img mb-4" style="background-image: url(/resources/images/person_2.jpg);"></div>--%>
<%--      				<div class="info text-center">--%>
<%--      					<h3><a href="teacher-single.html">Mark Wilson</a></h3>--%>
<%--      					<span class="position">Beard Specialist</span>--%>
<%--      					<div class="text">--%>
<%--	        				<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>--%>
<%--	        			</div>--%>
<%--      				</div>--%>
<%--        		</div>--%>
<%--        	</div>--%>
<%--        	<div class="col-lg-3 d-flex mb-sm-4 ftco-animate">--%>
<%--        		<div class="staff">--%>
<%--      				<div class="img mb-4" style="background-image: url(/resources/images/person_3.jpg);"></div>--%>
<%--      				<div class="info text-center">--%>
<%--      					<h3><a href="teacher-single.html">Patrick Jacobson</a></h3>--%>
<%--      					<span class="position">Hair Stylist</span>--%>
<%--      					<div class="text">--%>
<%--	        				<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>--%>
<%--	        			</div>--%>
<%--      				</div>--%>
<%--        		</div>--%>
<%--        	</div>--%>
<%--        	<div class="col-lg-3 d-flex mb-sm-4 ftco-animate">--%>
<%--        		<div class="staff">--%>
<%--      				<div class="img mb-4" style="background-image: url(/resources/images/person_4.jpg);"></div>--%>
<%--      				<div class="info text-center">--%>
<%--      					<h3><a href="teacher-single.html">Ivan Dorchsner</a></h3>--%>
<%--      					<span class="position">Beard Specialist</span>--%>
<%--      					<div class="text">--%>
<%--	        				<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>--%>
<%--	        			</div>--%>
<%--      				</div>--%>
<%--        		</div>--%>
<%--        	</div>--%>
        </div>
    </div>
</section>


<section class="ftco-counter ftco-bg-dark img" id="section-counter"
         style="background-image: url(/resources/images/bg_2.jpg);" data-stellar-background-ratio="0.5">
    <div class="overlay"></div>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-10">
                <div class="row">
                    <div class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
                        <div class="block-18 text-center">
                            <div class="text">
                                <div class="icon"><span class="flaticon-pizza-1"></span></div>
                                <strong class="number" data-number="100">0</strong>
                                <span>Pizza Branches</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
                        <div class="block-18 text-center">
                            <div class="text">
                                <div class="icon"><span class="flaticon-medal"></span></div>
                                <strong class="number" data-number="85">0</strong>
                                <span>Number of Awards</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
                        <div class="block-18 text-center">
                            <div class="text">
                                <div class="icon"><span class="flaticon-laugh"></span></div>
                                <strong class="number" data-number="10567">0</strong>
                                <span>Happy Customer</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
                        <div class="block-18 text-center">
                            <div class="text">
                                <div class="icon"><span class="flaticon-chef"></span></div>
                                <strong class="number" data-number="900">0</strong>
                                <span>Staff</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<section class="ftco-appointment">
    <div class="overlay"></div>
    <div class="container-wrap">
        <div class="row no-gutters d-md-flex align-items-center">
            <div class="col-md-6 d-flex align-self-stretch">
                <div id="map"></div>
            </div>
            <div class="col-md-6 appointment ftco-animate">
                <h3 class="mb-3">Contact Us</h3>
                <form action="#" class="appointment-form">
                    <div class="d-md-flex">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="First Name">
                        </div>
                    </div>
                    <div class="d-me-flex">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Last Name">
                        </div>
                    </div>
                    <div class="form-group">
                        <textarea name="" id="" cols="30" rows="3" class="form-control"
                                  placeholder="Message"></textarea>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Send" class="btn btn-primary py-3 px-4">
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<%@include file="../dynamic/board.jspf" %>

<%@include file="../dynamic/javaScript.jspf" %>

</body>
</html>