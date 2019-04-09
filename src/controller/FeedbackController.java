package controller;

import entity.FeedBack;
import model.FeedbackModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FeedbackController extends HttpServlet {
    private FeedbackModel model = new FeedbackModel();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("loggedUser");
        FeedBack feedBack = new FeedBack();
        feedBack.setUsername(username);
        feedBack.setContent(req.getParameter("content"));

        if (model.insert(feedBack)){
            resp.sendRedirect("/");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (model.delete(req.getParameter("id"))){
            resp.getWriter().println("Deleted");
        }else {
            resp.getWriter().println("Can not delete");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (model.apccept(req.getParameter("id"))){
            resp.getWriter().println("Accepted");
        }else {
            resp.getWriter().println("Can not accept");
        }

    }

}
