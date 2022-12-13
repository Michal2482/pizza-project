<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/css.jspf" %>
<body>
<%@include file="../dynamic/navigationMain.jspf" %>
<section class="ftco-section">
    <div class="container">
        <div class="row">
            <c:forEach items="${person}" var="category">
                <div class="col-lg-3 d-flex mb-sm-4 ftco-animate">
                    <div class="staff">
                        <div class="img mb-4" style="background-image: url(/resources/images/person_1.jpg);"></div>
                        <div class="info text-center">
                            <h3><a href="teacher-single.html">${category.name}</a></h3>
                            <h3><a href="teacher-single.html">${category.surname}</a></h3>
                                <span class="position">${category.job}</span>
                            <div class="text"><p>${category.description}</p>
                                <p class="price"><a href='<c:url value="/${prefix}/editPerson/${category.id}" />'
                                                    class="ml-2 btn btn-white btn-outline-white">Edit</a></p></div>
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