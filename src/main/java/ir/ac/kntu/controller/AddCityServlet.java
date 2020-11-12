package ir.ac.kntu.controller;

import ir.ac.kntu.domains.City;
import ir.ac.kntu.MyApp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/addCity")
public class AddCityServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RequestDispatcher rd = req.getRequestDispatcher("/Menu.jsp");
        PrintWriter out = resp.getWriter();

        try {
            String name = req.getParameter("name");
            String coordination = req.getParameter("coordination");
            City city = new City(name, coordination);
            MyApp.getCityService().saveOrUpdate(city);
            out.println("<font color=red> City Successfully Added </font>");
            rd.include(req, resp);

        } catch (Exception ex) {
            out.println("<font color=red>" + ex.getMessage() + "</font>");
            rd.include(req, resp);
        }
    }
}
