/*
 * @author Alireza.d.a
 */


package ir.ac.kntu.controller;

import ir.ac.kntu.MyApp;
import ir.ac.kntu.base.JalaliDate;
import ir.ac.kntu.domains.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/changeSituation")
public class ChangePostSituationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dateString = req.getParameter("date");
        JalaliDate date = new JalaliDate(dateString);
        List<Post> all = MyApp.getPostService().findAll();
        all.forEach((post) -> {
            JalaliDate sendDate = new JalaliDate(post.getSendDate());
            if (sendDate.compareTo(date) <= 0) {
                post.getReceiver().deleteReceivedPost(post);
                post.setSituation("SENT");
            }
            JalaliDate receiveDate = new JalaliDate(post.getReceiveDate());
            if (receiveDate.compareTo(date) <= 0) {
                post.setSituation("RECEIVED");
                post.getReceiver().addPostsTo(post);
            }
        });
        resp.sendRedirect("DisplayPosts.jsp");
    }
}
