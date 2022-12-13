<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/css.jspf" %>
<body>
<%@include file="../dynamic/navigationMain.jspf" %>
<h2 class="d-flex justify-content-center py-2 row">Category</h2>
<div class="row d-flex justify-content-center py-2">
    <p class="mb-4 mb-md-5 ">On this page you can edit and delete your meal category, which are display on MenuPage. Category is used also to connect with meal.</p>
</div>
<section class="ftco-menu">
    <div class="container-fluid">
        <div class="row d-md-flex justify-content-center">
            <c:forEach items="${category}" var="category">

                <div class="col-lg-8 ftco-animate p-md-3">
                    <div class="row">
                        <div class="col-md-4 nav-link-wrap mb-2">
                            <div class="nav ftco-animate nav-pills" id="v-pills-tab" role="tablist"
                                 aria-orientation="vertical">
                                <a class="nav-link" id="v-pills-2-tab" data-toggle="pill" href="#v-pills-2" role="tab"
                                   aria-controls="v-pills-2" aria-selected="false">${category.categoryName}</a>
                                <a href='<c:url value="/${prefix}/editCategory/${category.id}" />'
                                   class="ml-2 btn btn-white btn-outline-white p-3 px-xl-4 py-xl-3">Edytuj</a>
                            </div>
                        </div>

                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>

<%@include file="../dynamic/javaScript.jspf" %>

</body>
</html>