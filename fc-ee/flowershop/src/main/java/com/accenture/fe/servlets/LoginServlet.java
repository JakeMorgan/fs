package com.accenture.fe.servlets;

import com.accenture.be.business.UserBusinessService;
import com.accenture.be.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Autowired
    UserBusinessService userBusinessService;

    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        if(request.getParameter("loginsubmit") != null) {
            User user = userBusinessService.login(request.getParameter("username"), request.getParameter("password"));
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
            }
        }else if (request.getParameter("regsubmit") != null){
            User user = userBusinessService.register(request.getParameter("username"), request.getParameter("password"), "", "");
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException{
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
