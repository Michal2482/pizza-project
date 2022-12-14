<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/css.jspf" %>
<body>
<%@include file="../dynamic/navigationMain.jspf" %>

<section>
    <div class="container py-5 h-100">
        <div class="row form-group">
            <div class="col-lg-8 col-xl-6">
                <div class="border-top border-bottom border-3" style="border-color: #f37a27">
                    <div class="card-body p-5">

                        <p class="lead fw-bold mb-5" style="color: #ffffff;">Your Order</p>
                        <c:if test="${!order.orderedMeal.isEmpty()}">
                            <div class="mx-n5 px-5 py-4">
                                <c:forEach items="${order.orderedMeal}" var="element">
                                    <div class="row">
                                        <div class="col-md-8 col-lg-8">
                                            <span>${element.name}</span>
                                            <p>${element.description}</p>
                                        </div>
                                        <div class="col-md-3 col-lg-4" style="color:  #fac564;">
                                            <p>${element.price} €</p>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:if>
                        <c:if test="${order.orderedMeal.isEmpty()}">
                            <div class="text-center">
                                <h2>Your order is Empty</h2>
                                <a href="/${prefix}/menu">Add meals to order</a>
                            </div>
                        </c:if>
                        <div class=" py-4">
                            <p class="lead fw-bold mb-2 pb-2" style="color: #ffffff;">Order delivery</p>
                            <div class="pb-4 form-group">
                                <div class="form-check">
                                    <input class="form-check-input checked" type="radio" name="orderDelivery" id="eatIn"
                                           value="option1">
                                    <label class="form-check-label" for="eatIn">Eat in</label>
                                    <p>Come and choose a place</p>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="orderDelivery" id="takeaway"
                                           value="option2">
                                    <label class="form-check-label" for="takeaway">Takeaway</label>
                                    <p> Surcharge of 1 € per pack</p>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="orderDelivery" id="delivery"
                                           value="option3">
                                    <label class="form-check-label" for="delivery">Delivery</label>
                                    <p> Surcharge for delivery - 5 €<br>
                                        We deliver pizza up to 25km</p>
                                    </p>
                                </div>
                            </div>

                            <div class="row my-4">
                                <div class="col-md-6 offset-md-8 col-lg-6 offset-lg-8">
                                    <p class="lead fw-bold mb-0" style="color:  #fac564">Total: ${sum} €</p>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-12">

                                    <div class="horizontal-timeline">

                                        <ul class="list-inline items d-flex justify-content-between">
                                            <li class="list-inline-item items-list">
                                                <input class="btn btn-primary py-2 px-4 " type="submit"
                                                       value="Pay"></input>
                                            </li>
                                            <li class="list-inline-item items-list">
                                                <input class="btn btn-primary py-2 px-4 " type="submit"
                                                       value="Delete"></input>
                                            </li>
                                        </ul>

                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6 ftco-animate">
                <img src="/resources/images/pizza_delivery.png" class="img-fluid" alt="">
            </div>
        </div>

        <!-- The Modal -->
        <div class="modal" id="myModal">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Czy na pewno chcesz usunąć osobę ?</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        Jeżeli usuniesz to już nie będzie odwrotu
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Anuluj</button>
                        <form method="post" action='<c:url value="/editStudent/${student.id}"/>'>
                            <input type="submit" class="btn btn-danger pull-left" value="Tak"/>
                        </form>
                    </div>

                </div>

            </div>
        </div>
    </div>
</section>


<!-- loader -->
<div id="ftco-loader" class="show fullscreen">
    <svg class="circular" width="48px" height="48px">
        <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/>
        <circle
                class="path"
                cx="24"
                cy="24"
                r="22"
                fill="none"
                stroke-width="4"
                stroke-miterlimit="10"
                stroke="#F96D00"
        />
    </svg>
</div>

<%@include file="../dynamic/javaScript.jspf" %>
</body>
</html>