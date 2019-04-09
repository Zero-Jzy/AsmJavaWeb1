<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 2019-03-22
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HashMap<String,ArrayList<String>> errors =(HashMap<String, ArrayList<String>>) request.getAttribute("errors");
    if (errors == null){
        errors = new HashMap<>();
    }
    User user = (User) request.getAttribute("user");
    if (user == null){
        user = new User("","","");
    }

%>
<html>
<jsp:include page="fragment/client/head.jsp">
    <jsp:param name="title" value="Register"></jsp:param>
</jsp:include>
<body>
<jsp:include page="fragment/client/header.jsp"></jsp:include>

<div class="content container">
    <% for (Map.Entry<String, ArrayList<String>> e: errors.entrySet()) {%>
    <div class="alert alert-danger" role="alert">
        <%for (String err : e.getValue()){%>
        <%= err%>
        <% } %>
    </div>
    <%}%>

    <form class="form-group" action="/user" method="post">
        Username <input  class="form-control"  type="text" name="username" value="<%= user.getUsername()%>">
        <br>
        Password <input class="form-control" type="password" name="password">
        <br>
        Fullname <input class="form-control" type="text" name="fullName" value="<%= user.getFullName()%>">
        <br>
        <input type="submit" class="btn" value="Submit">
        <input type="reset" class="btn" value="Reset">
    </form>
</div>


<jsp:include page="fragment/client/footer.jsp"></jsp:include>
</body>
</html>
