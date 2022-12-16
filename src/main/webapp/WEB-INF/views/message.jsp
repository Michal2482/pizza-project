<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="dynamic/css.jspf" %>
<body>
<%@include file="dynamic/navigationMain.jspf" %>
<!-- END nav -->

<%--<section class="home-slider owl-carousel img" style="background-image: url(/resources/images/bg_1.jpg);">--%>
    <div class="container">
        <div class="jumbotron bg-dark">
            <div class="container text-center text-black jumbo-container">
                    <h1 class="display-3">Success</h1>
                    <p>Your order is being prepared!</p>
                <a href="/${prefix}/">Home Page</a>
            </div>
        </div>
    </div>
<%--</section>--%>
<%@include file="dynamic/board.jspf" %>

<%@include file="dynamic/javaScript.jspf" %>

</body>
</html>