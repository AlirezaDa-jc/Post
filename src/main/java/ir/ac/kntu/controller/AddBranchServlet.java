/*
 * @author Alireza.d.a
 */

package ir.ac.kntu.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/addBranch")
public class AddBranchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        RequestDispatcher rd = req.getRequestDispatcher("/Menu.jsp");
        PrintWriter out = resp.getWriter();
        out.println("<font color=red> Branch Successfully Added </font>");
        rd.include(req, resp);
    }
}
