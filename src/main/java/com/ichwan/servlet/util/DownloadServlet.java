package com.ichwan.servlet.util;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet(urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String file = req.getParameter("file");
        Path path = Path.of("upload/"+file);
        byte[] bytes = Files.readAllBytes(path);

        /**
         * buat parameter baru agar dapat mendownload langsung file tanpa harus membukanya
         * localhost:8080/download?file=filename.png&direct=true
         */
        String direct = req.getParameter("direct");
        if ("true".equals(direct)){
            resp.setHeader("Content-Disposition", "attachment; filename=\""+ path.getFileName() + "\"");
        }

        resp.getOutputStream().write(bytes);
    }
}
