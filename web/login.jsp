
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<jsp:include page="fragment/client/head.jsp">
    <jsp:param name="title" value="Login"></jsp:param>
</jsp:include>
<body>
<jsp:include page="fragment/client/header.jsp"></jsp:include>
<div class="container">
    <% if (request.getAttribute("errors") != null) {%>
    <div class="alert alert-danger" role="alert">
        <%= (String) request.getAttribute("errors")%>
    </div>
    <%}%>
    <div class="login-form">
        <div class="card card-outline-secondary">
            <div class="card-header">
                <h3 class="mb-0">Login</h3>
            </div>
            <div class="card-body">
                <form action="/login" method="post" autocomplete="off" class="form" id="formLogin" name="formLogin"
                      role="form">
                    <div class="form-group">
                        <label for="uname1">Username</label>
                        <input class="form-control" id="uname1" name="username" required="" type="text">
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input autocomplete="new-password" name="password" class="form-control" id="pwd1" required=""
                               type="password">
                    </div>
                    <button class="btn btn-info float-right mx-2">Login</button>
                    <button type="reset" class="btn btn-light float-right">reset</button>
                </form>
            </div><!--/card-block-->
        </div>
    </div>
</div>
<jsp:include page="fragment/client/footer.jsp"></jsp:include>
</body>
</html>
