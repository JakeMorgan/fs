package com.accenture.fe.servlets;

import com.accenture.be.business.UserBusinessService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegServlet extends HttpServlet {
    @Autowired
    UserBusinessService userBusinessService;

public void doPost(HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
    userBusinessService.register(request.getParameter("username"), request.getParameter("password"), request.getParameter("address"), request.getParameter("phone"));

}
public void doGet(HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException{
    request.getRequestDispatcher("registration.jsp").forward(request, response);
}
}