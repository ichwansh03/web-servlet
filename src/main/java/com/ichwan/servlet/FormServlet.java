package com.ichwan.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Path path = new File(getClass().getResource("/html/form.html").getFile()).toPath();
        String html = Files.readString(path);
        resp.getWriter().println(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("firstName") + " " + req.getParameter("lastName");
        String hello = "Semangat Pagi, " + name;
        resp.getWriter().println(hello);
    }
}
