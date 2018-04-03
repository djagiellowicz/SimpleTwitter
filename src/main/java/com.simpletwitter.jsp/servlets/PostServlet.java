package com.simpletwitter.jsp.servlets;

import com.simpletwitter.jsp.dao.PostDAO;
import com.simpletwitter.jsp.dao.PostDAOImpl;
import com.simpletwitter.jsp.dao.UserDAO;
import com.simpletwitter.jsp.dao.UserDAOImpl;
import com.simpletwitter.jsp.model.Post;
import com.simpletwitter.jsp.model.User;
import org.hibernate.PropertyValueException;
import org.hibernate.cfg.annotations.Nullability;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/post")
public class PostServlet extends HttpServlet {

    UserDAO userDAO = new UserDAOImpl();
    PostDAO postDAO = new PostDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/post.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String postText = req.getParameter("postText");
        Post userPost = new Post();
        //Protection against posting when user attribute in session is empty could be added here.
        User loggedUser = (User) req.getSession().getAttribute("loggedUser");

        userPost.setText(postText);
        userPost.setPostDate(LocalDateTime.now());
        userPost.setConnectedUser(loggedUser);
        //This try/catch prevents posting when user is not logged
        try {
            postDAO.savePost(userPost);
        }
        catch (PropertyValueException pve)
        {
            System.out.println("post has not been saved.");
            req.setAttribute("postError", true);
        }
        req.getRequestDispatcher("/post.jsp").forward(req,resp);
    }
}
