/*
 * @author Alireza.d.a
 */

package ir.ac.kntu.controller;

import ir.ac.kntu.MyApp;
import ir.ac.kntu.domains.City;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/displayCity")
public class DisplayCity extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cityString = req.getParameter("city");
        City city = MyApp.getCityService().findByName(cityString);
        System.out.println(city.getPostsFrom());
        System.out.println(city.getPostsTo());
        Cookie cookie = new Cookie("desiredCity", cityString);
        resp.addCookie(cookie);
        resp.sendRedirect("DisplayCity.jsp");
    }
}
