/*
 * @author Alireza.d.a
 */


package ir.ac.kntu.controller;

import ir.ac.kntu.MyApp;
import ir.ac.kntu.services.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/signin")
public class SignUpFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        resp.setContentType("text/html");
        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        UserService userService = MyApp.getUserService();
        if (userService.signIn(userName, password)) {
            chain.doFilter(req, resp);
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            PrintWriter out = resp.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            out.println("<a href=\"login.jsp\">Login!</a><br><br>");
            out.println("<a href=\"SignUp.html\">Sign In!!</a>");
            rd.include(req, resp);
        }
    }
}
