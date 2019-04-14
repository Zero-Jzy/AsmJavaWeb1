package filter;

import entity.User;
import model.UserModel;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Filter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        UserModel model = new UserModel();

        HttpSession httpSession = httpServletRequest.getSession();
        String username = (String) httpSession.getAttribute("loggedUser");
        User user;
        if (username != null && username.length() > 0 ) {
            user = model.finOne(username);
        }else {
            user = new User();
        }

        if (user.isUser()) {
            httpServletRequest.setAttribute("loggedIn", username);
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
