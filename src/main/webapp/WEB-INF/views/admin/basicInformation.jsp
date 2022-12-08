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
            <form method="post" class="contact-form" action='<c:url value="/${prefix}/admin/basicInformation"/>'>
                <h4>Basic Information</h4>
                <div class="form-group row">
                    <label class="col-2 col-form-label">Pizzeria name:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" name="firstPartName"
                               placeholder="Firt part of pizzeria name" value="${basicInformation.firstPartName}">
                    </div>
                    <div class="col-5">
                        <input class="form-control" type="text" name="SecondPartName"
                               placeholder="Second part of pizzeria name" value="${basicInformation.secondPartName}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-2 col-form-label">Phone number:</label>
                    <div class="col-4">
                        <input class="form-control" type="text" name="phoneNumber"
                               placeholder="phone number" value="${basicInformation.phoneNumber}">
                    </div>
                    <label class="col-1 col-form-label">E-mail:</label>
                    <div class="col-4">
                        <input class="form-control" type="email" name="Email" placeholder="your e-mail"
                               value="${basicInformation.email}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-2 col-form-label">Zip code:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" name="zipCode" placeholder="zip code"
                               value="${basicInformation.zipCode}">
                    </div>
                    <label class="col-2 col-form-label">City:</label>
                    <div class="col-4">
                        <input class="form-control" type="text" name="city" placeholder="city"
                               value="${basicInformation.city}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-2 col-form-label">Street:</label>
                    <div class="col-4">
                        <input class="form-control" type="text" name="street" placeholder="street"
                               value="${basicInformation.street}">
                    </div>
                    <label class="col-2 col-form-label">Nr:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" name="propertyNumber" placeholder="Number"
                               value="${basicInformation.propertyNumber}">
                    </div>
                </div>
                <h5>Open Hours</h5>
                <div class="form-group row">
                    <span>Monday</span>
                    <label for="openHoursMondayFrom" class="col-1 col-form-label">from:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursMondayFrom" name="openHoursMondayFrom" class="form-control"
                               value="${basicInformation.openHoursMondayFrom}">
                    </div>
                    <label for="openHoursMondayTo" class="col-1 col-form-label">to:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursMondayTo" name="openHoursMondayTo" class="form-control"
                               value="${basicInformation.openHoursMondayTo}">
                    </div>
                    <div class="col-1"></div>
                    <span>Tuesday</span>
                    <label for="openHoursTuesdayFrom" class="col-1 col-form-label">from:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursTuesdayFrom" name="openHoursTuesdayFrom" class="form-control"
                               value="${basicInformation.openHoursTuesdayFrom}">
                    </div>
                    <label for="openHoursTuesdayTo" class="col-1 col-form-label">to:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursTuesdayTo" name="openHoursTuesdayTo" class="form-control"
                               value="${basicInformation.openHoursTuesdayTo}">
                    </div>
                </div>
                <div class="form-group row">
                    <span>Wednesay</span>
                    <label for="openHoursWednesdayFrom" class="col-1 col-form-label">from:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursWednesdayFrom" name="openHoursWednesdayFrom"
                               class="form-control" value="${basicInformation.openHoursWednesdayFrom}">
                    </div>
                    <label for="openHoursWednesdayTo" class="col-1 col-form-label">to:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursWednesdayTo" name="openHoursWednesdayTo" class="form-control"
                               value="${basicInformation.openHoursWednesdayTo}">
                    </div>
                    <div class="col-1"></div>
                    <span>Thursday</span>
                    <label for="openHoursThursdayFrom" class="col-1 col-form-label">from:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursThursdayFrom" name="openHoursThursdayFrom" class="form-control"
                               value="${basicInformation.openHoursThursdayFrom}">
                    </div>
                    <label for="openHoursThursdayTo" class="col-1 col-form-label">to:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursThursdayTo" name="openHoursThursdayTo" class="form-control"
                               value="${basicInformation.openHoursThursdayTo}">
                    </div>
                </div>
                <div class="form-group row">
                    <span>Friday</span>
                    <label for="openHoursFridayFrom" class="col-1 col-form-label">from:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursFridayFrom" name="openHoursFridayFrom" class="form-control"
                               value="${basicInformation.openHoursFridayFrom}">
                    </div>
                    <label for="openHoursFridayTo" class="col-1 col-form-label">to:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursFridayTo" name="openHoursFridayTo" class="form-control"
                               value="${basicInformation.openHoursFridayTo}">
                    </div>
                    <div class="col-1"></div>
                    <span>Saturday</span>
                    <label for="openHoursSaturdayFrom" class="col-1 col-form-label">from:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursSaturdayFrom" name="openHoursSaturdayFrom" class="form-control"
                               value="${basicInformation.openHoursSaturdayFrom}">
                    </div>
                    <label for="openHoursSaturdayTo" class="col-1 col-form-label">to:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursSaturdayTo" name="openHoursSaturdayTo" class="form-control"
                               value="${basicInformation.openHoursSaturdayTo}">
                    </div>
                </div>
                <div class="form-group row">
                    <span>Sunday</span>
                    <label for="openHoursSundayFrom" class="col-1 col-form-label">from:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursSundayFrom" name="openHoursSundayFrom" class="form-control"
                               value="${basicInformation.openHoursSundayFrom}">
                    </div>
                    <label for="openHoursSundayTo" class="col-1 col-form-label">to:</label>
                    <div class="col-1">
                        <input type="time" id="openHoursSundayTo" name="openHoursSundayTo" class="form-control"
                               value="${basicInformation.openHoursSundayTo}">
                    </div>
                </div>

                <h5>Social Media:</h5>
                <div class="form-group row">
                    <label class="col-3 col-form-label">Twitter:</label>
                    <div class="col-8">
                        <input class="form-control" type="text" name="twitterUrl" placeholder="url Twitter"
                               value="${basicInformation.twitterUrl}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-3 col-form-label">Facebook:</label>
                    <div class="col-8">
                        <input class="form-control" type="text" name="facebookUrl" placeholder="url Facebook"
                               value="${basicInformation.facebookUrl}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-3 col-form-label">Instagram:</label>
                    <div class="col-8">
                        <input class="form-control" type="text" name="instagramUrl" placeholder="url Instagram"
                               value="${basicInformation.instagramUrl}">
                    </div>
                </div>

                <div class="d-flex justify-content-end">
                    <input class="btn btn-primary py-2 px-4" style="margin:10px" type="submit" name="submitAndGoAdminPage"
                           value="Save"/>
                    <input class="btn btn-primary py-2 px-4" style="margin:10px" type="submit" name="submitAndGoHomePage"
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
                        <form method="post" class="contact-form" action='<c:url value="/${prefix}/admin/basicInformation"/>'>
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