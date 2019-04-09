<header>
    <% String username = (String) request.getAttribute("loggedIn"); %>

    <nav class="navbar navbar-dark navbar-expand-md bg-dark mb-5">
        <div class="container">
            <% if (username != null) {%>
            <button class="btn btn-primary navbar-btn" data-toggle="modal"
                    data-target="#exampleModal">Feedback
            </button>
            <%}%>
            <div class="navbar-header">
                <a class="navbar-brand" href="#"> Assignment Java Web
                </a>
            </div>
            <ul class="nav navbar-nav float-right">
                <% if (username != null) {%>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <%= (String) request.getAttribute("loggedIn")%>
                    </a>

                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a href="/logout" class="dropdown-item">logout</a>
                    </div>
                </li>
                <%} else {%>
                <%--                    <li class="nav-item dropdown">--%>
                <%--                        <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink"--%>
                <%--                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                <%--                            Account--%>
                <%--                        </a>--%>

                <%--                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">--%>
                <%--                            <a href="/login" class="dropdown-item">login</a>--%>
                <%--                            <a href="/user" class="dropdown-item">register</a>--%>
                <%--                        </div>--%>
                <%--                    </li>--%>
                <li class="nav-item dropdown">
                    <a class="nav-link " href="/login">
                        Login
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link" href="/user">
                        Register
                    </a>
                </li>
                <%}%>
            </ul>



        </div>
    </nav>

    <!-- Modal -->

</header>
<% if (username != null) {%>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <form action="/feedback" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Send Feedback</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <label for="messenger">Messenger</label>
                    <textarea class="form-control" id="messenger" type="text" rows="3" name="content"></textarea>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-info" value="Send">
                </div>
            </div>
        </form>
    </div>
</div>
<%}%>

