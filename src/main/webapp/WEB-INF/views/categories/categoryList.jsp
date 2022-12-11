<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/css.jspf" %>
<body>
<%@include file="../dynamic/navigationMain.jspf" %>
<section class="ftco-menu">
    <div class="container-fluid">
        <div class="row d-md-flex">
            <c:forEach items="${category}" var="title">

                <div class="col-lg-8 ftco-animate p-md-5">
                    <div class="row">
                        <div class="col-md-12 nav-link-wrap mb-5">
                            <div class="nav ftco-animate nav-pills" id="v-pills-tab" role="tablist"
                                 aria-orientation="vertical">
                                <a class="nav-link" id="v-pills-2-tab" data-toggle="pill" href="#v-pills-2" role="tab"
                                   aria-controls="v-pills-2" aria-selected="false">${title.categoryName}</a>
                                <a href='<c:url value="/${prefix}/editCategory/${title.id}" />'
                                   class="ml-2 btn btn-white btn-outline-white">Edytuj</a>
                            </div>
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