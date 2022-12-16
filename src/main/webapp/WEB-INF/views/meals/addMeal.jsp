<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/css.jspf" %>
<body>
<%@include file="../dynamic/navigationMain.jspf" %>

<section class="ftco-section administration-section">
    <div class="container mt-4">
        <div class="row block-12">
            <div class="col-md-12 administration-info ftco-animate">

                <h5>Position of Menu</h5>
                <form method="post" enctype="multipart/form-data" class="contact-form" action='<c:url value="/${prefix}/addDish"/>'>
                    <div class="form-group row">
                        <label class="col-4 col-form-label"><h6>Photo</h6></label>
                        <div class="col-8">
                            <input class="form-control" type="file" name="file">
                        </div>

                        <label class="col-4 col-form-label"><h6>Product name</h6></label>
                        <div class="col-8">
                            <input class="form-control" type="text" name="name"
                                   placeholder="product name">
                        </div>

                        <label class="col-4 col-form-label"><h6>Category</h6></label>
                        <div class="col-8">
                            <%-- <select name="categoryId">--%>
                            <%-- <imput class="form-control" type="text" name="category.id" placeholder="Wpisz kategorię: pizza, makaron, burger, napój"></imput>&ndash;%&gt;--%>
                            <%--  <option hidden>Wybierz kategorię</option>--%>
                            <%--    <c:forEach items="${category}" var="title">--%>
                            <%--         <option value="${title.id}"> ${title.categoryName}</option>--%>
                            <%--    </c:forEach>--%>

                            <%--    </select>--%>
                            <select name="category.id" class="custom-select ">
                                <option hidden>Select Category</option>
                                <c:forEach items="${category}" var="category">
                                    <option value="${category.id}"> ${category.categoryName}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <label class="col-4 col-form-label"><h6>Price</h6></label>
                        <div class="col-8">
                            <input class="form-control" type="text" name="price" placeholder="Price">
                        </div>

                        <label class="col-4 col-form-label"><h6>Description Product</h6></label>
                        <div class="col-8">
                                    <textarea class="form-control" rows="4" id="descriptionProduct"
                                              name="description"
                                              placeholder="Description product and write ingredients"></textarea>
                        </div>
                    </div>
                        <div class="d-flex justify-content-end">
                            <input class="btn btn-primary py-2 px-4" type="submit" value="Save"/>
                        </div>

                </form>

            </div>
        </div>
    </div>
</section>

<div id="map"></div>

<%@include file="../dynamic/javaScript.jspf" %>

</body>
</html>