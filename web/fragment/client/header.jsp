<header>
    <% String username = (String) request.getAttribute("loggedIn"); %>

    <nav class="navbar navbar-dark navbar-expand-md bg-dark justify-content-between mb-5">
        <div class="container">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-nav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="navbar-collapse collapse dual-nav w-50 order-1 order-md-0">
                <ul class="navbar-nav">
                    <% if (username != null) {%>
                    <li class="nav-item active">
                        <a  type="button" class="nav-link btn btn-primary" name="btn" data-toggle="modal"
                           data-target="#exampleModal">
                            Feedback
                        </a>
                    </li>
                    <%}%>
                </ul>
            </div>
            <a href="/" class="navbar-brand mx-auto d-block text-center order-0 order-md-1 w-25">Assignment Java Web</a>
            <div class="navbar-collapse collapse dual-nav w-50 order-2">
                <ul class="nav navbar-nav ml-auto">
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
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Account
                        </a>

                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a href="/login" class="dropdown-item">login</a>
                            <a href="/user" class="dropdown-item">register</a>
                        </div>
                    </li>
                    <%}%>
                </ul>
            </div>

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

