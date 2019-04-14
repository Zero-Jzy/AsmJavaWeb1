<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.User" %>
<%@ page import="entity.UserInfomation" %>
<%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 2019-03-22
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
    User user = (User) request.getAttribute("user");
    if (user == null) {
        user = new User("", "", new UserInfomation("", "", "", ""));
    }

%>
<html>
<jsp:include page="fragment/client/head.jsp">
    <jsp:param name="title" value="Register"></jsp:param>
</jsp:include>
<body>
<jsp:include page="fragment/client/header.jsp"></jsp:include>

<div class="content container">
<%--    <% for (Map.Entry<String, ArrayList<String>> e : errors.entrySet()) {%>--%>
<%--    <div class="alert alert-danger" role="alert">--%>
<%--        <%for (String err : e.getValue()) {%>--%>
<%--        <%= err%>--%>
<%--        <% } %>--%>
<%--    </div>--%>
<%--    <%}%>--%>

    <div class="row justify-content-center">
        <div class="col-md-6 col-sm-10">
            <div class="card card-outline-secondary">
                <div class="card-header">
                    <h3 class="mb-0">Register</h3>
                </div>
                <div class="card-body">
                    <form action="/user" method="post">
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Full Name</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="text" name="fullname"
                                       value="<%= user.getUserInfomation().getFullName()%>">
                                <%if (errors.containsKey("fullname")) {%>
                                <small class="form-text text-muted err">
                                    <%for (String err :errors.get("fullname")){%>
                                    <%= err%>
                                    <%} %>
                                </small>
                                <%}%>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">User Name</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="text" name="username"
                                       value="<%= user.getUsername()%>">
                                <%if (errors.containsKey("username")) {%>
                                <small class="form-text text-muted err">
                                    <%for (String err :errors.get("username")){%>
                                    <%= err%>
                                    <%} %>
                                </small>
                                <%}%>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Password</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="password" name="password">
                                <%if (errors.containsKey("password")) {%>
                                <small class="form-text text-muted err">
                                    <%for (String err :errors.get("password")){%>
                                    <%= err%>
                                    <%} %>
                                </small>
                                <%}%>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Confirm</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="password" name="confirm_password">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Email</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="email" name="email"
                                       value="<%= user.getUserInfomation().getEmail()%>">
                                <%if (errors.containsKey("email")) {%>
                                <small class="form-text text-muted err">
                                    <%for (String err :errors.get("email")){%>
                                    <%= err%>
                                    <%} %>
                                </small>
                                <%}%>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Phone</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="number" name="phone"
                                       value="<%= user.getUserInfomation().getPhone()%>">
                                <%if (errors.containsKey("phone")) {%>
                                <small class="form-text text-muted err">
                                    <%for (String err :errors.get("phone")){%>
                                    <%= err%>
                                    <%} %>
                                </small>
                                <%}%>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Address</label>
                            <div class="col-lg-9">
                                <textarea class="form-control" name="address"></textarea>
                                <%if (errors.containsKey("address")) {%>
                                <small class="form-text text-muted err">
                                    <%for (String err :errors.get("address")){%>
                                    <%= err%>
                                    <%} %>
                                </small>
                                <%}%>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="float-right">
                                <input class="btn btn-secondary mx-3" type="reset" value="Reset">
                                <input class="btn btn-primary mr-3" type="submit" value="Submit">
                            </div>
                        </div>
                    </form>
                </div>
            </div><!-- /form user info -->
        </div>
    </div>
</div>


<jsp:include page="fragment/client/footer.jsp"></jsp:include>
</body>
</html>
