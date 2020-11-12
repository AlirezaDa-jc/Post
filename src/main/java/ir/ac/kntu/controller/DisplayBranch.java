/*
 * @author Alireza.d.a
 */

package ir.ac.kntu.controller;

import ir.ac.kntu.MyApp;
import ir.ac.kntu.domains.Branch;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/displayBranch")
public class DisplayBranch extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String branchString = req.getParameter("branch");
        Branch branch = MyApp.getBranchService().findById(Long.valueOf(branchString));
        System.out.println(branch.getPosts());
        Cookie cookie = new Cookie("desiredBranch", branchString);
        resp.addCookie(cookie);
        resp.sendRedirect("DisplayBranch.jsp");
    }
}
