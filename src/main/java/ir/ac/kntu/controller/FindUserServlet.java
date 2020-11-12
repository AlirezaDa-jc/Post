package ir.ac.kntu.controller;

import ir.ac.kntu.domains.Customer;
import ir.ac.kntu.MyApp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/findUser")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String nationalCode = req.getParameter("nationalCode");
        Customer desiredCustomer = new Customer(name, nationalCode);

        List<Customer> all = MyApp.getCustomerService().findAll();
        for (Customer customer :
                all) {
            if (customer.equals(desiredCustomer)) {
                Cookie cookie = new Cookie("desiredCustomer", customer.getId().toString());
                resp.addCookie(cookie);
                resp.sendRedirect("DisplayCustomer.jsp");
            }
        }

    }
}
