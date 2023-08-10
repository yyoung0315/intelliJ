package org.zerock.y1.controller;


import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.zerock.y1.dto.TodoDTO;
import org.zerock.y1.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
@Log
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("login get .......... ");

        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("login post .......... ");

        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");

        String str = mid+mpw;

        HttpSession session = req.getSession();
        session.setAttribute("loginInfo" , str);

        resp.sendRedirect("/todo/list");
    }

}
