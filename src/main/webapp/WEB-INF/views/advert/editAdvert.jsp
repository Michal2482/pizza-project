<%@ page import="org.apache.jasper.tagplugins.jstl.core.Url" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/css.jspf" %>
<body>
<%@include file="../dynamic/navigationMain.jspf" %>
<!-- END nav -->

<section class="ftco-section administration-section">
    <div class="container mt-4">
        <div class="col-md-12 contact-info ftco-animate">
            <h4>Position of Advert</h4>

            <c:choose>
                <c:when test="${param.newAdvertImage}">
                </c:when>
                <c:otherwise>
                    <form>
                        <input type="hidden" name="newAdvertImage" value="true">
                        <input type="submit" value="Zamień zdjęcie">
                    </form>
                </c:otherwise>
            </c:choose>
            <form method="post" enctype="multipart/form-data" class="contact-form" action='<c:url value="/${prefix}/admin/editAdvert/${id}"/>'>
                <div class="form-group row">
                    <label class="col-4 col-form-label">Photo Advert</label>
                    <c:choose>
                        <c:when test="${param.newAdvertImage}">
                            <div class="col-8">
                                <input class="form-control" type="file" value=${advert.photoAdvert} name="file" placeholder="Select photo">
                            </div>
                        </c:when>
                        <c:otherwise>
                            <img src="/${prefix}/advert/${advert.id}/image" width="200px" class="img-fluid" alt="">
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="form-group row">
                    <label class="col-4 col-form-label">Slogan</label>
                    <div class="col-8">
                        <input class="form-control" type="text" name="slogan" placeholder="Advertising slogan"
                               value="${advert.slogan}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-4 col-form-label">Product advert name</label>
                    <div class="col-8">
                        <input class="form-control" type="text" name="productAdvertName"
                               placeholder="Product advert name"
                               value="${advert.productAdvertName}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-4 col-form-label">Description advert</label>
                    <div class="col-8">
                        <input class="form-control" type="text" name="descriptionProductAdvert"
                               placeholder="Description advert"
                               value="${advert.descriptionProductAdvert}">
                    </div>
                </div>
                <div class="d-flex justify-content-end">
                    <input class="btn btn-primary py-2 px-4" style="margin:10px" type="submit"
                           name="submitAndGoAdverts"
                           value="Save"/>
                    <input class="btn btn-primary py-2 px-4" style="margin:10px" type="submit"
                           name="submitAndGoHomePage"
                           value="Save/Go Home Page"/>
                </div>
            </form>
        </div>

    </div>
</section>

<%@include file="../dynamic/javaScript.jspf" %>

</body>
</html>
