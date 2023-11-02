package com.ichwan.servlet;

import com.ichwan.servlet.model.HelloRequest;
import com.ichwan.servlet.util.JsonUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/api/hello")
public class RequestBodyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HelloRequest request = JsonUtil.getMapper().readValue(req.getReader(), HelloRequest.class);
        String hello = "Semangat pagi "+request.getFirstName()+" "+request.getLastName();

        Map<String, String> response = Map.of(
                "data request", hello
        );
        String jsonResponse = JsonUtil.getMapper().writeValueAsString(response);
        resp.setHeader("content-type","application/json");
        resp.getWriter().println(jsonResponse);
    }
}
