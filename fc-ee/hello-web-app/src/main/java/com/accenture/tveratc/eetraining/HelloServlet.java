package com.accenture.tveratc.eetraining;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        PrintWriter writer = resp.getWriter();

        if(!name.isEmpty())
            writer.println("Привет, " + name + "!");
        else
            writer.println("Привет аноним!");
    }
}
