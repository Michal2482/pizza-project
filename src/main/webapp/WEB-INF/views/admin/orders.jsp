<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/css.jspf" %>
<body>
<%@include file="../dynamic/navigationMain.jspf" %>

<h2 class="d-flex justify-content-center py-2 row">Orders</h2>
<div class="row d-flex justify-content-center py-2">
    <p class="mb-4 mb-md-5 ">On this page you can see the dishes to prepare and delete finished</p>
</div>

<section class="ftco-menu">
    <div class="container">
        <div class="row slider-text align-items-center" data-scrollax-parent="true">
            <div class="card-body">
                <td class="table-responsive">
                    <table class="table action-panel" id="dataTable">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Address</th>
                            <th>Phone Number</th>
                            <th>Meals</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${orders}" var="orderElement">
                            <tr>
                                <td>${orderElement.id}</td>
                                <td>${orderElement.address}</td>
                                <td>${orderElement.telephone}</td>
                                <td>
                                <c:forEach items="${orderElement.orderedMeal}" var="meal">
                                    <div class="row">
                                    ${meal.name}
                                    </div>
                                </c:forEach>
                                </td>
                                <td>${orderElement.status}</td>
                                <td>
                                    <a href='<c:url value="/${prefix}/admin/order"><c:param name="id" value="${orderElement.id}"/></c:url> ' class="btn btn-primary">Done</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
        </div>
    </div>
</section>


<%@include file="../dynamic/javaScript.jspf" %>

</body>
</html>