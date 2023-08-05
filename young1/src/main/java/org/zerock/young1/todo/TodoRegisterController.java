package org.zerock.young1.todo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoRegisterController", value = "/org/zerock/young1/todo/register")
public class TodoRegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("입력화면을볼수있도록구성");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/register.jsp");

        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("입력을처리하고목록페이지로이동");

        resp.sendRedirect("/org/zerock/young1/todo/list");
    }
}
