package filter;

import entity.User;
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
        User user;
        if (username != null && username.length() > 0 ) {
            user = model.finOne(username);
        }else {
            user = new User();
        }

        if (user.isAdmin()) {
            httpServletRequest.setAttribute("loggedIn", username);
        }else {
            httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
