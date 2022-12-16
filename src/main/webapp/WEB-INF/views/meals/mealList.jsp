<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/css.jspf" %>
<body>
<%@include file="../dynamic/navigationMain.jspf" %>

<section class="ftco-section">

    <div class="container-wrap">
        <div class="row no-gutters d-flex">
            <c:forEach items="${meal}" var="mealElement">
                <div class="col-lg-4 d-flex ftco-animate">
                    <div class="services-wrap d-flex">
                        <a href='' class="img" style="background-image: url(/${prefix}/meal/${mealElement.id}/image);"></a>
                        <div class="text p-4">
                            <h3>${mealElement.name}</h3>
                            <p>${mealElement.description}</p>
                            <p class="price"><span>${mealElement.price}</span> <a href='<c:url value="/${prefix}/editDish/${mealElement.id}"/>' class="ml-2 btn btn-white btn-outline-white">Edit</a></p>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>


</section>


<%@include file="../dynamic/javaScript.jspf" %>

</body>
</html>