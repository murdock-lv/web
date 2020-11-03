package com.bla.laa.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExampleThree", description = "JSP Servlet With Annotations", urlPatterns = { "/servlet" })
public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    //http://localhost:8080/servlet?message=123
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        request.setAttribute("text", message);
        request.getRequestDispatcher("/servlet/servlet.jsp").forward(request, response);
    }

}
