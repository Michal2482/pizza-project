<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/css.jspf" %>
<body>
<%@include file="../dynamic/navigationMain.jspf" %>
<!-- END nav -->

<%--<section class="home-slider owl-carousel img" style="background-image: url(/resources/images/bg_1.jpg);">--%>

<%--    <div class="slider-item" style="background-image: url(/resources/images/bg_3.jpg);">--%>
<%--        <div class="overlay"></div>--%>
<%--        <div class="container">--%>
<%--            <div class="row slider-text justify-content-center align-items-center">--%>

<%--                <div class="col-md-7 col-sm-12 text-center ftco-animate">--%>
<%--                    <h1 class="mb-3 mt-5 bread">Administration</h1>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>

<section class="ftco-section administration-section">
    <div class="container mt-5">
        <div class="row block-12">
            <div class="col-md-12 administration-info ftco-animate">
                <div class="row">

<%--                    <form action="#" class="contact-form">--%>
<%--                        <div class="col-md-12 mb-4">--%>
<%--                            <h2 class="h4">Basic Information</h2>--%>
<%--                            <div class="form-group row">--%>
<%--                                <label class="col-2 col-form-label"><h6>Pizzeria name:</h6></label>--%>
<%--                                <div class="col-5">--%>
<%--                                    <input class="form-control" type="text" name="firstPartName"--%>
<%--                                           placeholder="Firt part of pizzeria name">--%>
<%--                                </div>--%>
<%--                                <div class="col-5">--%>
<%--                                    <input class="form-control" type="text" name="SecondPartName"--%>
<%--                                           placeholder="Second part of pizzeria name">--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="form-group row">--%>
<%--                                <label class="col-2 col-form-label"><h6>Phone number:</h6></label>--%>
<%--                                <div class="col-4">--%>
<%--                                    <input class="form-control" type="text" name="phoneNumber"--%>
<%--                                           placeholder="phone number">--%>
<%--                                </div>--%>
<%--                                <label class="col-2 col-form-label"><h6>E-mail:</h6></label>--%>
<%--                                <div class="col-4">--%>
<%--                                    <input class="form-control" type="text" name="Email" placeholder="your e-mail">--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="form-group row">--%>
<%--                                <label class="col-1 col-form-label"><h6>City:</h6></label>--%>
<%--                                <div class="col-3">--%>
<%--                                    <input class="form-control" type="text" name="city" placeholder="city">--%>
<%--                                </div>--%>
<%--                                <label class="col-1 col-form-label"><h6>Street:</h6></label>--%>
<%--                                <div class="col-3">--%>
<%--                                    <input class="form-control" type="text" name="street" placeholder="street">--%>
<%--                                </div>--%>
<%--                                <label class="col-1 col-form-label"><h6>Nr:</h6></label>--%>
<%--                                <div class="col-4">--%>
<%--                                    <input class="form-control" type="text" name="propertyNumber"--%>
<%--                                           placeholder="property number ">--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <h5>Open Hours</h5>--%>
<%--                            <div class="form-group row">--%>
<%--                                <label class="col-2 col-form-label"><h6>Monday:</h6></label>--%>
<%--                                <div class="col-2">--%>
<%--                                    <input class="form-control" type="text" name="facebook" placeholder="from - to">--%>
<%--                                </div>--%>
<%--                                <label class="col-2 col-form-label"><h6>Tuesday:</h6></label>--%>
<%--                                <div class="col-2">--%>
<%--                                    <input class="form-control" type="text" name="facebook" placeholder="from - to">--%>
<%--                                </div>--%>
<%--                                <label class="col-2 col-form-label"><h6>Wednesday:</h6></label>--%>
<%--                                <div class="col-2">--%>
<%--                                    <input class="form-control" type="text" name="facebook" placeholder="from - to">--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="form-group row">--%>
<%--                                <label class="col-2 col-form-label"><h6>Thursday:</h6></label>--%>
<%--                                <div class="col-2">--%>
<%--                                    <input class="form-control" type="text" name="facebook" placeholder="from - to">--%>
<%--                                </div>--%>
<%--                                <label class="col-2 col-form-label"><h6>Friday:</h6></label>--%>
<%--                                <div class="col-2">--%>
<%--                                    <input class="form-control" type="text" name="facebook" placeholder="from - to">--%>
<%--                                </div>--%>
<%--                                <label class="col-2 col-form-label"><h6>Saturday:</h6></label>--%>
<%--                                <div class="col-2">--%>
<%--                                    <input class="form-control" type="text" name="facebook" placeholder="from - to">--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="form-group row">--%>
<%--                                <label class="col-2 col-form-label"><h6>Sunday:</h6></label>--%>
<%--                                <div class="col-2">--%>
<%--                                    <input class="form-control" type="text" name="facebook" placeholder="from - to">--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <h5>Social Media:</h5>--%>
<%--                            <div class="form-group row">--%>
<%--                                <label class="col-3 col-form-label"><h6>Twitter:</h6></label>--%>
<%--                                <div class="col-8">--%>
<%--                                    <input class="form-control" type="text" name="twitter" placeholder="url Twitter">--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="form-group row">--%>
<%--                                <label class="col-3 col-form-label"><h6>Facebook:</h6></label>--%>
<%--                                <div class="col-8">--%>
<%--                                    <input class="form-control" type="text" name="facebook" placeholder="url Facebook">--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="form-group row">--%>
<%--                                <label class="col-3 col-form-label"><h6>Instagram:</h6></label>--%>
<%--                                <div class="col-8">--%>
<%--                                    <input class="form-control" type="text" name="instagram"--%>
<%--                                           placeholder="url Instagram">--%>
<%--                                </div>--%>
<%--                            </div>--%>

<%--                            <input class="btn btn-primary py-2 px-4 pull-right" type="submit" value="Save"></input>--%>
<%--                    </form>--%>

<%--                    <form action="#" class="home-form">--%>
<%--                        <h2 class="h4">Home Page</h2>--%>
<%--                        <div class="form-group row">--%>
<%--                            <label class="col-4 col-form-label"><h6>Short despription Menu Page:</h6></label>--%>
<%--                            <div class="col-8">--%>
<%--                                <textarea class="form-control" rows="5" id="shortDescriptionMenuPage"--%>
<%--                                          name="shortDescriptionMenuPage"--%>
<%--                                          placeholder="Short despription Menu Page"></textarea>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <h5>Position of Advert</h5>--%>
<%--                        To wszystko obudowac w seletca od tego miejsca<br>--%>
<%--                        Tytaj dodać selecta z możliwością dodania do zakładaek "burgers, drinks, pizza itp"--%>
<%--                        <div class="form-group">--%>
<%--                            <div class="row">--%>
<%--                                <label class="col-4 col-form-label"><h6>Photo Advert</h6></label>--%>
<%--                                <div class="col-8">--%>
<%--                                    <input class="form-control" type="text" name="photoAdvert"--%>
<%--                                           placeholder="trzeba to jakos edytować z możliwością dodania zdjęcia">--%>
<%--                                </div>--%>
<%--                            </div>--%>

<%--                            <div class="row">--%>
<%--                                <label class="col-4 col-form-label"><h6>Slogan</h6></label>--%>
<%--                                <div class="col-8">--%>
<%--                                    <input class="form-control" type="text" name="slogan" placeholder="slogan">--%>
<%--                                </div>--%>
<%--                            </div>--%>

<%--                            <div class="row">--%>
<%--                                <label class="col-4 col-form-label"><h6>Product name</h6></label>--%>
<%--                                <div class="col-8">--%>
<%--                                    <input class="form-control" type="text" name="ProductAdvertName[1]"--%>
<%--                                           placeholder="product Advert name">--%>
<%--                                </div>--%>
<%--                            </div>--%>

<%--                            <div class="row">--%>
<%--                                <label class="col-4 col-form-label"><h6>Description Product</h6></label>--%>
<%--                                <div class="col-8">--%>
<%--                                    <textarea class="form-control" rows="4" id="descriptionPizza"--%>
<%--                                              name="descriptionProduct"--%>
<%--                                              placeholder="Description Product and ingredients"></textarea>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            To wszystko obudowac w seletca do tego miejsca<br>--%>
<%--                            <input class="btn btn-primary py-2 px-4 pull-right" type="submit" value="Save"></input>--%>
<%--                    </form>--%>


<%--                    <form action="#" class="menu-form">--%>
<%--                        <h2 class="h4">Menu Page</h2>--%>
<%--                        <div class="form-group row">--%>
<%--                            <label class="col-4 col-form-label"><h6>Short despription Menu Page:</h6></label>--%>
<%--                            <div class="col-8">--%>
<%--                                <textarea class="form-control" rows="5" id="shortDescriptionMenuPage"--%>
<%--                                          name="shortDescriptionMenuPage"--%>
<%--                                          placeholder="Short despription Menu Page"></textarea>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <h5>Category:</h5>--%>
<%--                        <form action="#" class="menu-form">--%>
<%--                            To wszystko obudowac w możliwośc dodawania kolejnych kategorii. Może po prostu dodanie--%>
<%--                            jednej kategorii -> "save" i tak po kolei będą dodawac się do bazy<br>--%>
<%--                            <div class="row">--%>
<%--                                <label class="col-4 col-form-label"><h6>Product name</h6></label>--%>
<%--                                <div class="col-8">--%>
<%--                                    <input class="form-control" type="text" name="ProductName[1]"--%>
<%--                                           placeholder="product name">--%>
<%--                                </div>--%>
<%--                            </div>--%>

<%--                            <input class="btn btn-primary py-2 px-4 pull-right" type="submit" value="Save"></input>--%>
<%--                        </form>--%>
                        <h5>Position of Menu</h5>
                        <form method="post" action='<c:url value="/editDish"/>'>
                        To wszystko obudowac w seletca od tego miejsca<br>
                        Tytaj dodać selecta z możliwością dodania do zakładaek "burgers, drinks, pizza itp"
                        <div class="form-group">
                            <div class="row">
                                <label class="col-4 col-form-label"><h6>Photo</h6></label>
                                <div class="col-8">
                                    <input class="form-control" type="text" name="photo"
                                           placeholder="trzeba to jakos edytować z możliwością dodania zdjęcia">
                                </div>
                            </div>

                            <div class="row">
                                <label class="col-4 col-form-label"><h6>Product name</h6></label>
                                <div class="col-8">
                                    <input class="form-control" type="text" value="${meal.name}" placeholder="nazwa dania">
                                </div>
                            </div>

                            <div class="row">
                                <label class="col-4 col-form-label"><h6>Category</h6></label>
                                <div class="col-8">
                                    To na pewno też musi być opkaowane jakimś selectem, tak, żeby użytkownik wyierał
                                    sobie kategorie, a nie wpisywał kolejne
                                    <input class="form-control" type="text" value="${meal.category}" placeholder="Wpisz kategorię: pizza, makaron, burger, napój">
                                </div>
                            </div>

                            <div class="row">
                                <label class="col-4 col-form-label"><h6>Price</h6></label>
                                <div class="col-8">
                                    <input class="form-control" type="text" value="${meal.price}" placeholder="Wpisz cenę">
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-4 col-form-label"><h6>Description Product</h6></label>
                                <div class="col-8">
                                    <input class="form-control" rows="4" id="descriptionProduct" value="${meal.description}" placeholder="Podaj opis i składniki">
                                </div>
                            </div>
                            To wszystko obudowac w seletca do tego miejsca<br>
                            <input class="btn btn-primary py-2 px-4 pull-right" type="submit" value="Zapisz"></input>
                        </div>
                        </form>
<%--                    </form>--%>

<%--                    <form action="#" class="menu-form">--%>
<%--                        <h2 class="h4">Services Page</h2>--%>
<%--                        <div class="form-group row">--%>
<%--                            <label class="col-4 col-form-label"><h6>Short despription Services Page:</h6></label>--%>
<%--                            <div class="col-8">--%>
<%--                                <textarea class="form-control" rows="5" id="shortDescriptionServicesPage"--%>
<%--                                          name="shortDescriptionServicesPage"--%>
<%--                                          placeholder="Short despription Services Page"></textarea>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <h5>Position of Services</h5>--%>
<%--                        To wszystko obudowac w seletca od tego miejsca<br>--%>
<%--                        <div class="form-group">--%>
<%--                            <div class="row">--%>
<%--                                <label class="col-4 col-form-label"><h6>Picture</h6></label>--%>
<%--                                <div class="col-8">--%>
<%--                                    <input class="form-control" type="text" name="picture"--%>
<%--                                           placeholder="trzeba to jakos edytować z możliwością dodania zdjęcia">--%>
<%--                                </div>--%>
<%--                            </div>--%>

<%--                            <div class="row">--%>
<%--                                <label class="col-4 col-form-label"><h6>Service name</h6></label>--%>
<%--                                <div class="col-8">--%>
<%--                                    <input class="form-control" type="text" name="ServiceName[1]"--%>
<%--                                           placeholder="service name">--%>
<%--                                </div>--%>
<%--                            </div>--%>

<%--                            <div class="row">--%>
<%--                                <label class="col-4 col-form-label"><h6>Description Service</h6></label>--%>
<%--                                <div class="col-8">--%>
<%--                                    <textarea class="form-control" rows="4" id="descriptionService"--%>
<%--                                              name="descriptionService" placeholder="Description Service"></textarea>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            To wszystko obudowac w seletca do tego miejsca<br>--%>
<%--                            <input class="btn btn-primary py-2 px-4 pull-right" type="submit" value="Save"></input>--%>
<%--                    </form>--%>
                </div>
            </div>
        </div>
    </div>
</section>

<div id="map"></div>

<%@include file="../dynamic/javaScript.jspf" %>

</body>
</html>