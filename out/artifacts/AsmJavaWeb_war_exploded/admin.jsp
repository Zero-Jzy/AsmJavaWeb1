<%@ page import="entity.FeedBack" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.UserModel" %><%--
  Created by IntelliJ IDEA.
  User: phu
  Date: 08/04/2019
  Time: 09:14
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    ArrayList<FeedBack> feedBacks = (ArrayList<FeedBack>) request.getAttribute("feedbacks");
    UserModel userModel = new UserModel();
%>
<html>
<jsp:include page="fragment/client/head.jsp">
    <jsp:param name="title" value="Admin page"></jsp:param>
    <jsp:param name="description" value="Mô tả"></jsp:param>
    <jsp:param name="keywords" value="keyword1, keyword2"></jsp:param>
</jsp:include>

<body>
<jsp:include page="fragment/client/header.jsp"></jsp:include>

<div class="alert-dark">Đây là trang Amdin</div>

<div class="container">
    <% for (FeedBack feedBack: feedBacks) {%>

    <div class="card mb-4 shadow-sm">
        <div class="card-header">
            <%= userModel.finOne(feedBack.getUsername()).getFullName()%>
            <div class="float-right">
                <button class="btn btn-danger" onclick="doDelete(<%= feedBack.getId()%>)">delete</button>
                <button class="btn btn-primary" onclick="doPut(<%= String.valueOf(feedBack.getId())%>)">accept</button>

            </div>
        </div>
        <div class="card-body">
            <blockquote class="blockquote mb-0">
                <p><%= feedBack.getContent()%></p>
                <small class="float-right"><%= feedBack.getCreateAt()%></small>
            </blockquote>
        </div>
    </div>
    <%}%>

</div>

<script>
    function doDelete(id) {
        $.ajax({
            url: '/feedback?id=' + id,
            type: 'DELETE',
            success: function (result) {
                alert(result)
            },
            error: function (err) {
                alert(err)
            }
        });
    }

    function doPut(id) {
        $.ajax({
            url: '/feedback?id=' + id,
            type: 'PUT',
            success: function (result) {
                alert(result)
            },
            error: function (err) {
                alert(err)
            }
        });
    }

</script>
<jsp:include page="fragment/client/footer.jsp"></jsp:include>
</body>

</html>
