<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/css.jspf" %>
<body>
<%@include file="../dynamic/navigationMain.jspf" %>
<!-- END nav -->

<section class="ftco-section administration-section">
    <div class="container mt-4">
        <div class="col-md-12 contact-info ftco-animate">
            <form:form method="post" enctype="multipart/form-data" modelAttribute="form" class="contact-form" action="/${prefix}/admin/addAdvert">

                <h4>Position of Advert</h4>
                <div class="form-group row">
                    <label class="col-4 col-form-label">Photo Advert</label>
                    <div class="col-8">
                        <input class="form-control" type="file" name="file"
                               id="photoAdvert" path="photoAdvert"/>

                        <c:if test="${not empty errorMessage}">
                            <div class="text-danger">${errorMessage}</div>
                        </c:if>

                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-4 col-form-label">Slogan</label>
                    <div class="col-8">
                        <form:input class="form-control" type="text" name="slogan" placeholder="Advertising slogan"
                               id="slogan" path="slogan"/>
                        <form:errors path="slogan" class="text-danger" />
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-4 col-form-label">Product advert name</label>
                    <div class="col-8">
                        <form:input class="form-control" type="text" name="productAdvertName" placeholder="Product advert name"
                               path="productAdvertName"/>
                        <form:errors path="productAdvertName" class="text-danger" />
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-4 col-form-label">Description advert</label>
                    <div class="col-8">
                        <form:input class="form-control" type="text" name="descriptionProductAdvert" placeholder="Description advert"
                               path="descriptionProductAdvert"/>
                        <form:errors path="descriptionProductAdvert" class="text-danger" />
                    </div>
                </div>
                <div class="d-flex justify-content-end">
                    <input class="btn btn-primary py-2 px-4" style="margin:10px" type="submit"
                           name="submitAndGoAdminPage"
                           value="Save"/>
                    <input class="btn btn-primary py-2 px-4" style="margin:10px" type="submit"
                           name="submitAndGoHomePage"
                           value="Save/Go Home Page"/>
                </div>

            </form:form>
        </div>
    </div>
</section>

<%@include file="../dynamic/javaScript.jspf" %>

</body>
</html>