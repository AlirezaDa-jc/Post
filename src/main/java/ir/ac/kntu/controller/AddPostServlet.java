/*
 * @author Alireza.d.a
 */


package ir.ac.kntu.controller;


import ir.ac.kntu.MyApp;
import ir.ac.kntu.base.JalaliDate;
import ir.ac.kntu.domains.Branch;
import ir.ac.kntu.domains.City;
import ir.ac.kntu.domains.Customer;
import ir.ac.kntu.domains.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/addPost")
public class AddPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String customerFromString = req.getParameter("customerFrom");
        String customerToString = req.getParameter("customerTo");
        String branchString = req.getParameter("branch");
        String cityString = req.getParameter("city");
        double weight = Double.parseDouble(req.getParameter("weight"));
        String sendDateString = req.getParameter("senddate");
        String receiveDateString = req.getParameter("receivedate");
        String situation = req.getParameter("situation").toUpperCase();
        String transportation = req.getParameter("transportation").toUpperCase();
        String type = req.getParameter("type");
        JalaliDate sendDate = new JalaliDate(sendDateString);
        JalaliDate receiveDate = new JalaliDate(receiveDateString);
        Branch branch = MyApp.getBranchService().findById(Long.valueOf(branchString));
        City city = MyApp.getCityService().findByName(cityString);
        Customer customerFrom = MyApp.getCustomerService().findById(Long.valueOf(customerFromString));
        Customer customerTo = MyApp.getCustomerService().findById(Long.valueOf(customerToString));
        Post post = new Post();
        post.setName(name);
        post.setSender(customerFrom);
        post.setReceiver(customerTo);
        post.setBranch(branch);
        post.setFrom(branch.getCity());
        post.setTo(city);
        post.setSendDate(sendDate);
        post.setReceiveDate(receiveDate);
        post.setWeight(weight);
        post.setSituation(situation);
        post.setTransportation(transportation);
        post.setType(type);
        resp.setContentType("text/html");
        RequestDispatcher rd = req.getRequestDispatcher("/Menu.jsp");
        PrintWriter out = resp.getWriter();
        try {
            MyApp.getPostService().saveOrUpdate(post);
            out.println("<font color=red> Post Successfully Added </font>");
            rd.include(req, resp);
        } catch (IllegalArgumentException ex) {
            out.println("<font color=red>" + ex.getMessage() + "</font>");
            rd.include(req, resp);
        }
    }
}
