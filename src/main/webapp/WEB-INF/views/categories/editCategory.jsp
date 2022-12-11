<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/css.jspf" %>
<body>
<%@include file="../dynamic/navigationMain.jspf" %>
<section class="ftco-section administration-section">
    <div class="container mt-4">
        <div class="col-md-12 contact-info ftco-animate">

            <form method="post" action='<c:url value="/${prefix}/addCategory/${category.id}" />'>
                    <h4>Category:</h4>
                    <div class="form-group row">
                        <label class="col-4 col-form-label">Category name::</label>
                        <div class="col-8">
                            <input class="form-control" type="text" name="categoryName" value="${category.categoryName}"
                                   placeholder="Category name">
                        </div>
                    </div>
                    <div class="d-flex justify-content-end">
                        <input class="btn btn-primary py-2 px-4" style="margin:10px" type="submit" value="Zapisz">
                    </div>
            </form>
            <form method="post" action='<c:url value="/${prefix}/editCategory/${category.id}" />'>
                <div class="d-flex justify-content-end">
                    <input class="btn btn-danger py-2 px-4 " style="margin:10px" type="submit" value="Delete">
                </div>
            </form>


        </div>
    </div>
</section>

<%@include file="../dynamic/javaScript.jspf" %>

</body>
</html>