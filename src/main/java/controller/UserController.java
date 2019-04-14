package controller;

import entity.User;
import entity.UserInfomation;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("title", "Trang đăng ký");
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullname");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");

        System.out.println(req.getParameter("fullname"));

        UserInfomation userInfomation = new UserInfomation(fullName, email, address, phone);

        User user = new User(username, password, userInfomation);
        if (!user.isValid()) {
            HashMap<String, ArrayList<String>> errors = user.getErrors();
            req.setAttribute("errors", errors);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }
        UserModel userModel = new UserModel();
        userModel.insert(user, userInfomation);
        HttpSession session = req.getSession();
        session.setAttribute("loggedUser", user.getUsername());
        resp.sendRedirect("/home");


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Deleted");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Putted.");
    }
}
