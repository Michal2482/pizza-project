<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/css.jspf" %>
<body>
<%@include file="../dynamic/navigationMain.jspf" %>

<section class="ftco-section administration-section">
    <div class="container mt-5">
        <div class="row block-12">
            <div class="col-md-12 administration-info ftco-animate">
                <div class="row">
                        <h5>Position of Menu</h5>
                        <form method="post" action='<c:url value="/${prefix}/addDish"/>'>
                        <div class="form-group">
                            <div class="row">
                                <label class="col-4 col-form-label"><h6>Photo</h6></label>
                                <div class="col-8">
                                    <input class="form-control" type="text" name="photo"
                                           placeholder="photo">
                                </div>
                            </div>

                            <div class="row">
                                <label class="col-4 col-form-label"><h6>Product name</h6></label>
                                <div class="col-8">
                                    <input class="form-control" type="text" name="name"
                                           placeholder="product name">
                                </div>
                            </div>

                            <div class="row">
                                <label class="col-4 col-form-label"><h6>Category</h6></label>
                                <div class="col-8">
<%--                                    <select name="categoryId">--%>
<%--&lt;%&ndash;                                    <imput class="form-control" type="text" name="category.id" placeholder="Wpisz kategorię: pizza, makaron, burger, napój"></imput>&ndash;%&gt;--%>
<%--                                        <option hidden>Wybierz kategorię</option>--%>
<%--                                        <c:forEach items="${category}" var="title">--%>
<%--                                            <option value="${title.id}"> ${title.categoryName}</option>--%>
<%--                                        </c:forEach>--%>

<%--                                    </select>--%>
                                    <select name="category.id">
                                        <option hidden>Select Category</option>
                                        <c:forEach items="${category}" var="title">
                                            <option value="${title.id}"> ${title.categoryName}</option>
                                        </c:forEach>

                                    </select>

                                </div>
                            </div>

                            <div class="row">
                                <label class="col-4 col-form-label"><h6>Price</h6></label>
                                <div class="col-8">
                                    <input class="form-control" type="text" name="price" placeholder="Price">
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-4 col-form-label"><h6>Description Product</h6></label>
                                <div class="col-8">
                                    <textarea class="form-control" rows="4" id="descriptionProduct"
                                              name="description"
                                              placeholder="Description product and write ingredients">
                                    </textarea>
                                </div>
                            </div>
                            <input class="btn btn-primary py-2 px-4 pull-right" type="submit" value="Save"></input>
                        </div>
                        </form>
                </div>
            </div>
        </div>
    </div>
</section>

<div id="map"></div>

<%@include file="../dynamic/javaScript.jspf" %>

</body>
</html>