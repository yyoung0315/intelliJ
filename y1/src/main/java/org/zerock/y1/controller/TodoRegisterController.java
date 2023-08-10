package org.zerock.y1.controller;


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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "todoRegisterController", value = "/todo/register")
@Log4j2
public class TodoRegisterController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("todo /register Get ......................");
        HttpSession session = req.getSession();
        if(session.isNew()){
            log.info("JSESSIONID 쿠키가 새로 만들어진 사용자");
            resp.sendRedirect("/login");
            return;
        }

        if (session.getAttribute("loginInfo") == null){
            log.info("로그인한 정보가 없는 사용자");
            resp.sendRedirect("login");
            return;
        }
        req.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        TodoDTO todoDTO =TodoDTO.builder()
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("dueDate"),DATEFORMATTER))
                .build();

        log.info("/todo/register  Post .....");
        log.info(todoDTO);

        try {
            todoService.register(todoDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/todo/list");
    }

}
