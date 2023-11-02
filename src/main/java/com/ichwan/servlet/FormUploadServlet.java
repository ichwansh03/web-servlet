package com.ichwan.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet(urlPatterns = "/form-upload")
public class FormUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Path path = Path.of(FormUploadServlet.class.getResource("/html/form-upload.html").getPath());
        String html = Files.readString(path);
        resp.getWriter().println(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //jika parameter lebih dari satu, gunakan getParameterNames()
        String name = req.getParameter("name");
        Part profile = req.getPart("profile");

        Path uploadLocation = Path.of("/upload" + profile.getSubmittedFileName());
        Files.copy(profile.getInputStream(), uploadLocation);

        resp.getWriter().println("hello "+name+", your profile pic in "+uploadLocation.toAbsolutePath());
    }
}
