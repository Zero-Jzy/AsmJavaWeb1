<header>
    <% String username = (String) request.getAttribute("loggedIn"); %>

    <nav class="navbar navbar-dark navbar-expand-md bg-info justify-content-between mb-5">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="/home"> Assignment Java Web
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

</header>

