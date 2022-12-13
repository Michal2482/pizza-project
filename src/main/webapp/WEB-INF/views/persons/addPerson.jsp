<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/css.jspf" %>
<body>
<%@include file="../dynamic/navigationMain.jspf" %>

<section class="ftco-section administration-section">
    <div class="container mt-4">
        <div class="row block-12">
            <div class="col-md-12 administration-info ftco-animate">

                <h5>Position of Staff</h5>
                <form method="post" class="contact-form" action='<c:url value="/${prefix}/addPerson"/>'>
                    <div class="form-group row">
                        <label class="col-4 col-form-label"><h6>Photo</h6></label>
                        <div class="col-8">
                            <input class="form-control" type="text" name="photo"
                                   placeholder="trzeba to jakos edytować z możliwością dodania zdjęcia">
                        </div>

                        <label class="col-4 col-form-label"><h6>Name</h6></label>
                        <div class="col-8">
                            <input class="form-control" type="text" name="name"
                                   placeholder="Name">
                        </div>

                        <label class="col-4 col-form-label"><h6>Surname</h6></label>
                        <div class="col-8">
                            <input class="form-control" type="text" name="surname"
                                   placeholder="Surname">
                        </div>

                        <label class="col-4 col-form-label"><h6>Job</h6></label>
                        <div class="col-8">
                            <input class="form-control" type="text" name="job"
                                   placeholder="Job">
                        </div>

                        <label class="col-4 col-form-label"><h6>Description</h6></label>
                        <div class="col-8">
                                    <textarea class="form-control" rows="4" id="descriptionProduct"
                                              name="description"
                                              placeholder="Description"></textarea>
                        </div>
                    </div>
                    <div class="d-flex justify-content-end">
                        <input class="btn btn-primary py-2 px-4 pull-right" type="submit" value="Save"></input>
                    </div>
                </form>

            </div>
        </div>
    </div>
    </div>
</section>

<div id="map"></div>

<%@include file="../dynamic/javaScript.jspf" %>

</body>
</html>