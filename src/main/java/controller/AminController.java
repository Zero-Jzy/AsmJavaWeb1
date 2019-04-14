package controller;

import entity.FeedBack;
import model.FeedbackModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        FeedbackModel model = new FeedbackModel();
        ArrayList<FeedBack> feedBacks = model.getAll();
        req.setAttribute("feedbacks",feedBacks);
        req.getRequestDispatcher("admin.jsp").forward(req, resp);
    }

}
