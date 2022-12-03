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
                        <input class="form-control" type="email" name="Email" placeholder="your e-mail">
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
                    <span>Monday</span>
                    <label for="openHoursMondayFrom" class="col-1 col-form-label">from:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursMondayFrom" name="openHoursMonday" class="form-control">
                    </div>
                    <label for="openHoursMondayTo" class="col-1 col-form-label">to:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursMondayTo" name="openHoursMonday" class="form-control">
                    </div>
                    <div class="col-1"></div>
                    <span>Tuesday</span>
                    <label for="openHoursTuesdayFrom" class="col-1 col-form-label">from:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursTuesdayFrom" name="openHoursMonday" class="form-control">
                    </div>
                    <label for="openHoursTuesdayTo" class="col-1 col-form-label">to:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursTuesdayTo" name="openHoursMonday" class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <span>Wednesay</span>
                    <label for="openHoursWednesayFrom" class="col-1 col-form-label">from:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursWednesayFrom" name="openHoursMonday" class="form-control">
                    </div>
                    <label for="openHoursWednesayTo" class="col-1 col-form-label">to:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursWednesayTo" name="openHoursMonday" class="form-control">
                    </div>
                    <div class="col-1"></div>
                    <span>Thursday</span>
                    <label for="openHoursThursdayFrom" class="col-1 col-form-label">from:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursThursdayFrom" name="openHoursMonday" class="form-control">
                    </div>
                    <label for="openHoursThursdayTo" class="col-1 col-form-label">to:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursThursdayTo" name="openHoursMonday" class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <span>Friday</span>
                    <label for="openHoursFridayFrom" class="col-1 col-form-label">from:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursFridayFrom" name="openHoursMonday" class="form-control">
                    </div>
                    <label for="openHoursFridayTo" class="col-1 col-form-label">to:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursFridayTo" name="openHoursMonday" class="form-control">
                    </div>
                    <div class="col-1"></div>
                    <span>Saturday</span>
                    <label for="openHoursSaturdayFrom" class="col-1 col-form-label">from:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursSaturdayFrom" name="openHoursMonday" class="form-control">
                    </div>
                    <label for="openHoursSaturdayTo" class="col-1 col-form-label">to:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursSaturdayTo" name="openHoursMonday" class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <span>Sunday</span>
                    <label for="openHoursSundayFrom" class="col-1 col-form-label">from:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursSundayFrom" name="openHoursMonday" class="form-control"
                               min="09:00" max="18:00" required>
                    </div>
                    <label for="openHoursSundayTo" class="col-1 col-form-label">to:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursSundayTo" name="openHoursMonday" class="form-control"
                               min="09:00" max="18:00" required>
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

        </div>
    </div>
</section>

<div id="map"></div>

<%@include file="../dynamic/javaScript.jspf" %>

</body>
</html>