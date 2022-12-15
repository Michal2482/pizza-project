<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/css.jspf" %>
<body>
<%@include file="../dynamic/navigationMain.jspf" %>

<h2 class="d-flex justify-content-center py-2 row">Adverts</h2>
<div class="row d-flex justify-content-center py-2">
    <p class="mb-4 mb-md-5 ">On this page you can edit and delete your advert, which are display on HomePage</p>
</div>

<c:forEach items="${adverts}" var="advertElement">
    <section class="home-slider owl-carousel img row form-group"
             style="background-image: url(/resources/images/bg_1.jpg);">
        <div class="slider-item">
            <div class="overlay"></div>
            <div class="container">
                <div class="row slider-text align-items-center" data-scrollax-parent="true">

                    <div class="col-md-6 col-sm-12 ftco-animate">
                        <span class="subheading">${advertElement.slogan}</span>
                        <h1 class="mb-4">${advertElement.productAdvertName}</h1>
                        <p class="mb-4 mb-md-5">${advertElement.descriptionProductAdvert}</p>
                        <a href='<c:url value="/${prefix}/admin/editAdvert/${advertElement.id}"/>'
                           class="btn btn-primary p-3 px-xl-4 py-xl-3">Edit</a>
                        <button type="button" class="btn btn-danger p-3 px-xl-4 py-xl-3" data-toggle="modal"
                                style="margin:10px"
                                data-target="#myModal">Delete
                        </button>
                    </div>

                    <div class="col-md-6 ftco-animate">
                        <img src="/${prefix}/advert/${advertElement.id}/image" class="img-fluid" alt="">
                    </div>

                </div>

            </div>
        </div>
    </section>
    <div class="modal" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="h4-black">Are you sure?</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    If you delete it, it doesn't return
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
                    <form method="post" class="contact-form"
                          action='<c:url value="/${prefix}/admin/deleteAdvert/${advertElement.id}"/>'>
                        <input type="submit" class="btn btn-danger" name="delete" value="Delete"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</c:forEach>

<%@include file="../dynamic/javaScript.jspf" %>

</body>
</html>