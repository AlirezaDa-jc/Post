package ir.ac.kntu.controller;

import ir.ac.kntu.MyApp;
import ir.ac.kntu.domains.Branch;
import ir.ac.kntu.domains.City;
import ir.ac.kntu.services.BranchService;
import ir.ac.kntu.services.CityService;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/addBranch")
public class AddBranchFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        String cityName = req.getParameter("city");
        int employees = Integer.parseInt(req.getParameter("employees"));
        BranchService branchService = MyApp.getBranchService();
        CityService cityService = MyApp.getCityService();
        City city = cityService.findByName(cityName);
        PrintWriter out = resp.getWriter();
        assert city != null;
        Branch branch = new Branch();
        branch.setCity(city);
        branch.setEmployees(employees);
        System.out.println(branch.getEmployees());
        branchService.saveOrUpdate(branch);
        city.addBranch(branch);
        cityService.saveOrUpdate(city);
        chain.doFilter(req, resp);

    }
}
