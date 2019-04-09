<%@ page contentType="text/html;charset=UTF-8" %>

<%
    String title = request.getParameter("title");
%>

<head>
    <title><%= title%></title>
    <meta charset="utf-8">
    <script type="text/javascript" src="../../lib/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../../lib/bootstrap.min.js"></script>
<%--    <link rel="stylesheet" href="../../css/style.css">--%>
    <link rel="stylesheet" type="text/css" href="../../lib/bootstrap.min.css">
</head>