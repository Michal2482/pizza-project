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
            <form method="post" class="contact-form" action='<c:url value="/${prefix}/admin/advert"/>'>
                <h4>Position of Advert</h4>
                <div class="form-group row">
                    <label class="col-4 col-form-label">Photo Advert</label>
                    <div class="col-8">
                        <input class="form-control" type="text" name="photoAdvert" placeholder="wybierz zdjęcie"
                               value="">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-4 col-form-label">Slogan</label>
                    <div class="col-8">
                        <input class="form-control" type="text" name="slogan" placeholder="Advertising slogan"
                               value="">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-4 col-form-label">Product advert name</label>
                    <div class="col-8">
                        <input class="form-control" type="text" name="productAdvertName" placeholder="Product advert name"
                               value="">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-4 col-form-label">Description advert</label>
                    <div class="col-8">
                        <input class="form-control" type="text" name="descriptionProductAdvert" placeholder="Description advert"
                               value="">
                    </div>
                </div>
                <div class="d-flex justify-content-end">
                    <input class="btn btn-primary py-2 px-4" style="margin:10px" type="submit"
                           name="submitAndGoAdminPage"
                           value="Save"/>
                    <input class="btn btn-primary py-2 px-4" style="margin:10px" type="submit"
                           name="submitAndGoHomePage"
                           value="Save/Go Home Page"/>

                    <button type="button" class="btn btn-danger" data-toggle="modal" style="margin:10px"
                            data-target="#myModal">Delete
                    </button>
                </div>
            </form>
        </div>
        <!-- The Modal -->
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
                              action='<c:url value="/${prefix}/admin/descriptionOnPages"/>'>
                            <input type="submit" class="btn btn-danger" name="submitAndGoHomePage" value="Delete"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<%@include file="../dynamic/javaScript.jspf" %>

</body>
</html>