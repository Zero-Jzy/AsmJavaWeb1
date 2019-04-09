package filter;

import model.UserModel;

import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FilterAdmin implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        HttpSession httpSession = httpServletRequest.getSession();
        UserModel model = new UserModel();
        String username = (String) httpSession.getAttribute("loggedUser");

        int role = 0;
        if (username != null)  role = model.finOne(username).getRole();

        if (username != null && username.length() > 0 && role == 2) {
            httpServletRequest.setAttribute("loggedIn", username);
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }

    @Override
    public void destroy() {

    }
}
