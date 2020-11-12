/*
 * @author Alireza.d.a
 */


package ir.ac.kntu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet("/LogOutServlet")
public class LogOutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    System.out.println("JSESSIONID=" + cookie.getValue());
                    HttpSession session = request.getSession(false);
                    System.out.println("User=" + session.getAttribute("user"));
                    System.out.println("Logged Out!");
                    session.invalidate();
                    response.sendRedirect("login.jsp");
                    break;
                }
            }
        }
    }

}