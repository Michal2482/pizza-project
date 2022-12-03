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
            <form action="#" class="contact-form">
                <h4>Basic Information</h4>
                <div class="form-group row">
                    <label class="col-2 col-form-label">Pizzeria name:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" name="firstPartName"
                               placeholder="Firt part of pizzeria name">
                    </div>
                    <div class="col-5">
                        <input class="form-control" type="text" name="SecondPartName"
                               placeholder="Second part of pizzeria name">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-2 col-form-label">Phone number:</label>
                    <div class="col-4">
                        <input class="form-control" type="text" name="phoneNumber"
                               placeholder="phone number">
                    </div>
                    <label class="col-1 col-form-label">E-mail:</label>
                    <div class="col-4">
                        <input class="form-control" type="text" name="Email" placeholder="your e-mail">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-1 col-form-label">City:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" name="city" placeholder="city">
                    </div>
                    <label class="col-1 col-form-label">Street:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" name="street" placeholder="street">
                    </div>
                    <label class="col-2 col-form-label">Nr:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" name="propertyNumber"
                               placeholder="Number">
                    </div>
                </div>
                <h5>Open Hours</h5>
                <div class="form-group row">
                    <label class="col-2 col-form-label">Monday:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" name="facebook" placeholder="from - to">
                    </div>
                    <label class="col-2 col-form-label">Tuesday:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" name="facebook" placeholder="from - to">
                    </div>
                    <label class="col-2 col-form-label">Wednesday:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" name="facebook" placeholder="from - to">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-2 col-form-label">Thursday:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" name="facebook" placeholder="from - to">
                    </div>
                    <label class="col-2 col-form-label">Friday:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" name="facebook" placeholder="from - to">
                    </div>
                    <label class="col-2 col-form-label">Saturday:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" name="facebook" placeholder="from - to">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-2 col-form-label">Sunday:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" name="facebook" placeholder="from - to">
                    </div>
                </div>
                <h5>Social Media:</h5>
                <div class="form-group row">
                    <label class="col-3 col-form-label">Twitter:</label>
                    <div class="col-8">
                        <input class="form-control" type="text" name="twitter" placeholder="url Twitter">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-3 col-form-label">Facebook:</label>
                    <div class="col-8">
                        <input class="form-control" type="text" name="facebook" placeholder="url Facebook">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-3 col-form-label">Instagram:</label>
                    <div class="col-8">
                        <input class="form-control" type="text" name="instagram"
                               placeholder="url Instagram">
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

            <form action="#" class="contact-form">
                <h4>Description on pages</h4>
                <div class="form-group row">
                    <label class="col-4 col-form-label">Short description Home
                        Page:</label>
                    <div class="col-8">
                                <textarea class="form-control" rows="5" id="shortDescriptionHomePage"
                                          name="shortDescriptionHomePage"
                                          placeholder="Short despription Home Page"></textarea>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-4 col-form-label">Short description Menu
                        Page:</label>
                    <div class="col-8">
                                <textarea class="form-control" rows="5" id="shortDescriptionMenuPage"
                                          name="shortDescriptionMenuPage"
                                          placeholder="Short despription Menu Page"></textarea>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-4 col-form-label">Short despription Services
                        Page:</label>
                    <div class="col-8">
                                <textarea class="form-control" rows="5" id="shortDescriptionServicesPage"
                                          name="shortDescriptionServicesPage"
                                          placeholder="Short despription Services Page"></textarea>
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

            <form action="#" class="contact-form">
                <h4>Position of Advert</h4>
                To wszystko obudowac w seletca od tego miejsca<br>
                Tytaj dodać selecta z możliwością dodania do zakładaek "burgers, drinks, pizza itp"
                <div class="form-group row">
                    <label class="col-4 col-form-label">Photo Advert</label>
                    <div class="col-8">
                        <input class="form-control" type="text" name="photoAdvert"
                               placeholder="trzeba to jakos edytować z możliwością dodania zdjęcia">
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-4 col-form-label">Slogan</label>
                    <div class="col-8">
                        <input class="form-control" type="text" name="slogan" placeholder="slogan">
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-4 col-form-label">Product name</label>
                    <div class="col-8">
                        <input class="form-control" type="text" name="ProductAdvertName[1]"
                               placeholder="product Advert name">
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-4 col-form-label">Description Product</label>
                    <div class="col-8">
                                    <textarea class="form-control" rows="4" id="descriptionPizza"
                                              name="descriptionProduct"
                                              placeholder="Description Product and ingredients"></textarea>
                    </div>
                </div>
                To wszystko obudowac w seletca do tego miejsca<br>

                <div class="d-flex justify-content-end">
                    <input class="btn btn-primary py-2 px-4" style="margin:10px" type="submit"
                           value="Save">
                    <input class="btn btn-primary py-2 px-4" style="margin:10px" type="submit"
                           value="Edit">
                    <input class="btn btn-danger py-2 px-4" style="margin:10px" type="submit"
                           value="Delete">
                </div>
            </form>

            <form action="#" class="contact-form">
                <h4>Category:</h4>
                To wszystko obudowac w możliwośc dodawania kolejnych kategorii. Może po prostu dodanie
                jednej kategorii -> "save" i tak po kolei będą dodawac się do bazy<br>
                <div class="form-group row">
                    <label class="col-4 col-form-label">Product name</label>
                    <div class="col-8">
                        <input class="form-control" type="text" name="ProductName[1]"
                               placeholder="product name">
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
            <form action="#" class="contact-form">
                <h4>Position of Menu</h4>
                To wszystko obudowac w seletca od tego miejsca<br>
                Tytaj dodać selecta z możliwością dodania do zakładaek "burgers, drinks, pizza itp"
<%--                <div class="form-group row">--%>
<%--                    <label class="col-4 col-form-label">Photo</label>--%>
<%--                    <div class="col-8">--%>
<%--                        <input class="form-control" type="text" name="photo"--%>
<%--                               placeholder="trzeba to jakos edytować z możliwością dodania zdjęcia">--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="form-group row">--%>
<%--                    <label class="col-4 col-form-label">Product name</label>--%>
<%--                    <div class="col-8">--%>
<%--                        <input class="form-control" type="text" name="ProductName[1]"--%>
<%--                               placeholder="product name">--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="form-group row">--%>
<%--                    <label class="col-4 col-form-label">Category</label>--%>
<%--                    <div class="col-8">--%>
<%--                        To na pewno też musi być opkaowane jakimś selectem, tak, żeby użytkownik wyierał--%>
<%--                        sobie kategorie, a nie wpisywał kolejne--%>
<%--                        <input class="form-control" type="text" name="Category" placeholder="category">--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="form-group row">--%>
<%--                    <label class="col-4 col-form-label">Price:</label>--%>
<%--                    <div class="col-8">--%>
<%--                        <input class="form-control" type="text" name="pizzaPrice" placeholder="price">--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="form-group row">--%>
<%--                    <label class="col-4 col-form-label">Description Product</label>--%>
<%--                    <div class="col-8">--%>
<%--                        <textarea class="form-control" rows="4" id="descriptionProduct"--%>
<%--                                  name="descriptionProduct"--%>
<%--                                  placeholder="Description Product and ingredients"></textarea>--%>
<%--                    </div>--%>
<%--                    To wszystko obudowac w seletca do tego miejsca<br>--%>
<%--                </div>--%>
                <div class="d-flex justify-content-end">
<%--                    <input class="btn btn-primary py-2 px-4" style="margin:10px" type="submit"--%>
<%--                           value="Save">--%>
                    <a class="btn btn-primary py-2 px-4" style="margin:10px" href='<c:url value="/addDish" />' role="button">Add dish</a>
<%--                    <a class="btn btn-primary py-2 px-4" style="margin:10px" href='<c:url value="/editDish" />' role="button">Edit dish</a>--%>
                    <a class="btn btn-primary py-2 px-4" style="margin:10px" href='<c:url value="/edit2Dish" />' role="button">Edit dish</a>

<%--                    <input class="btn btn-primary py-2 px-4" style="margin:10px" type="submit"--%>
<%--                           value="Edit">--%>
<%--                    <input class="btn btn-danger py-2 px-4" style="margin:10px" type="submit"--%>
<%--                           value="Delete">--%>
                </div>
            </form>

            <form action="#" class="contact-form">
                <h4>Position of Services</h4>
                To wszystko obudowac w seletca od tego miejsca<br>
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
                To wszystko obudowac w seletca do tego miejsca<br>
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