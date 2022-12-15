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
        <div class="jumbotron home-jumbo">
            <div class="container text-center text-white jumbo-container">


                    <h1 class="display-3" value="${message.title}">Sukces</h1>
                    <p value="">${message.content}</p>



                    <h1 class="display-3">Sukces</h1>
                    <p value="${message}">Wszystko poszło zgodnie z planem. Hurra!</p>

                <a href="/">Powrót do strony głównej</a>
            </div>
        </div>
    </div>
<%--</section>--%>
<%@include file="dynamic/board.jspf" %>

<%@include file="dynamic/javaScript.jspf" %>

</body>
</html>