package controller;

import entity.User;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginController extends HttpServlet {

    private UserModel userModel = new UserModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = checkLogin(username, password);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("loggedUser", user.getUsername());
            resp.sendRedirect("/home");
        } else {
            req.setAttribute("errors", "Sai thông tin tài khoản.");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    private User checkLogin(String username, String password) {
        User user = userModel.getUserByUserNameAndPassword(username, password);
        if (user != null) {
            return user;
        }
        return null;
    }

}
