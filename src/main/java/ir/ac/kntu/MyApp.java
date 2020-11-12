/*
 * @author Alireza.d.a
 */

package ir.ac.kntu;

import ir.ac.kntu.services.*;
import ir.ac.kntu.services.impl.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyApp {
    private static final UserService userService = new UserServiceImpl();
    private static final BranchService BRANCH_SERVICE = new BranchServiceImpl();
    private static final CustomerService CUSTOMER_SERVICE = new CustomerServiceImpl();
    private static final CityService CITY_SERVICE = new CityServiceImpl();
    private static final PostService POST_SERVICE = new PostServiceImpl();

    public static PostService getPostService() {
        return POST_SERVICE;
    }

    public static CityService getCityService() {
        return CITY_SERVICE;
    }

    public static CustomerService getCustomerService() {
        return CUSTOMER_SERVICE;
    }

    public static BranchService getBranchService() {
        return BRANCH_SERVICE;
    }

    public static UserService getUserService() {
        return userService;
    }

    public static void addUserCookie(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = req.getParameter("username");


        HttpSession session = req.getSession(true);
        session.setAttribute("user", userName);
        session.setMaxInactiveInterval(3 * 60);
        Cookie user = new Cookie("user", userName);
        user.setMaxAge(30 * 60);
        resp.addCookie(user);
        resp.sendRedirect("SuccessfulLogin.jsp");
    }
}
