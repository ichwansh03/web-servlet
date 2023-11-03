package com.ichwan.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/todolist")
public class TodoListServlet extends HttpServlet {

    List<String> todos = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(todos);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String todo = req.getParameter("todo");
        if (todo!=null){
            todos.add(todo);
            resp.getWriter().println("add todo: "+todo);
        } else {
            resp.getWriter().println("todo parameter must exists");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index = Integer.parseInt(req.getParameter("index"));
        String updateTodo = req.getParameter("todo");

        if (index >= 0 && index < todos.size() && updateTodo != null && !updateTodo.isEmpty()){
            todos.set(index, updateTodo);
            resp.getWriter().println("todo updated at "+index+" : "+updateTodo);
        } else {
            resp.getWriter().println("invalid updated");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index = Integer.parseInt(req.getParameter("index"));

        if (index >= 0 && index < todos.size()){
            String remove = todos.remove(index);
            resp.getWriter().println("todo deleted at index "+index+" : "+remove);
        } else {
            resp.getWriter().println("invalid deleted");
        }
    }
}
