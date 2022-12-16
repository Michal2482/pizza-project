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
                    <h1 class="mb-3 mt-5 bread">Administration</h1>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="ftco-section administration-section">
    <div class="container mt-4">
        <div class="col-md-12 contact-info ftco-animate">

            <h4>Orders</h4>
            <p> Display orders</p>
            <div class="d-flex justify-content-end">
                <a class="btn btn-primary py-2 px-4" style="margin:10px"
                   href='<c:url value="/${prefix}/admin/orders" />' role="button">Orders</a>
            </div>
                <h4>Basic Information</h4>
                <p> Pizzeria name, Phone number, E-mail</p>
                <p> Address, Open hours, Social media, Short Description Pizzeria</p>
                <div class="d-flex justify-content-end">
                    <a class="btn btn-primary py-2 px-4" style="margin:10px"
                       href='<c:url value="/${prefix}/admin/basicInformation" />' role="button">Edit</a>
                </div>

            <h4>Description on pages</h4>
            <p> Description on:</p>
            <p> Home Page, Menu Page and Services Page</p>
            <div class="d-flex justify-content-end">
                <a class="btn btn-primary py-2 px-4" style="margin:10px"
                   href='<c:url value="/${prefix}/admin/descriptionOnPages" />' role="button">Edit</a>
            </div>

            <h4>Position of Advert</h4>
            <div class="d-flex justify-content-end">
                <a class="btn btn-primary py-2 px-4" style="margin:10px" href='<c:url value="/${prefix}/admin/addAdvert" />'
                   role="button">Add advert</a>
                <a class="btn btn-primary py-2 px-4" style="margin:10px" href='<c:url value="/${prefix}/admin/adverts" />'
                   role="button">Edit advert</a>
            </div>

            <h4>Category:</h4>
            <div class="d-flex justify-content-end">
                <a class="btn btn-primary py-2 px-4" style="margin:10px" href='<c:url value="/${prefix}/addCategory" />'
                   role="button">Add category</a>
                <a class="btn btn-primary py-2 px-4" style="margin:10px" href='<c:url value="/${prefix}/categories" />'
                   role="button">Edit category</a>
            </div>

            <h4>Position of Menu</h4>
            <div class="d-flex justify-content-end">
                <a class="btn btn-primary py-2 px-4" style="margin:10px" href='<c:url value="/${prefix}/addDish" />'
                   role="button">Add dish</a>
                <a class="btn btn-primary py-2 px-4" style="margin:10px" href='<c:url value="/${prefix}/mealList" />'
                   role="button">Edit dish</a>
            </div>

            <h4>Position of Staff</h4>
            <div class="d-flex justify-content-end">
                <a class="btn btn-primary py-2 px-4" style="margin:10px" href='<c:url value="/${prefix}/addPerson" />'
                   role="button">Add person</a>
                <a class="btn btn-primary py-2 px-4" style="margin:10px" href='<c:url value="/${prefix}/personList" />'
                   role="button">Edit person</a>
            </div>

            <form action="#" class="contact-form">
                <h4>Position of Services</h4>

                <div class="form-group row">

                    <label class="col-4 col-form-label">Picture</label>
                    <div class="col-8">
                        <input class="form-control" type="text" name="picture"
                               placeholder="trzeba to jakos edytować z możliwością dodania zdjęcia">
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-4 col-form-labe">Service name</label>
                    <div class="col-8">
                        <input class="form-control" type="text" name="ServiceName[1]"
                               placeholder="service name">
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-4 col-form-label">Description Service</label>
                    <div class="col-8">
                                    <textarea class="form-control" rows="4" id="descriptionService"
                                              name="descriptionService" placeholder="Description Service"></textarea>
                    </div>
                </div>

                <div class="d-flex justify-content-end">
                    <input class="btn btn-primary py-2 px-4" style="margin:10px" type="submit"
                           value="Save">
                    <input class="btn btn-primary py-2 px-4" style="margin:10px" type="submit"
                           value="Edit">
                    <input class="btn btn-danger py-2 px-4" style="margin:10px" type="submit"
                           value="Delete">
                </div>
            </form>
        </div>
    </div>
</section>

<div id="map"></div>

<%@include file="../dynamic/javaScript.jspf" %>

</body>
</html>