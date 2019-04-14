<%--
  Created by IntelliJ IDEA.
  User: phu
  Date: 10/04/2019
  Time: 00:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/fragment/client/head.jsp">
    <jsp:param name="title" value="Errors 404"></jsp:param>
</jsp:include>
<body>
<div class="page-wrap d-flex flex-row align-items-center">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-12 text-center">
                <span class="display-1 d-block">404</span>
                <div class="mb-4 lead">Trang không tồn tại.</div>
                <p>Quay lại trang <a href="/home">home</a> ?</p>

            </div>
        </div>
    </div>
</div>
</body>
</html>
