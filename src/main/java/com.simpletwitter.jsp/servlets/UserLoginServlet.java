package com.simpletwitter.jsp.servlets;

import com.simpletwitter.jsp.dao.UserDAO;
import com.simpletwitter.jsp.dao.UserDAOImpl;
import com.simpletwitter.jsp.model.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class UserLoginServlet extends HttpServlet {
    UserDAO userDao = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String givenLogin = req.getParameter("login").toLowerCase();
        String givenPassword = req.getParameter("password");
        User userWithGivenLogin = userDao.getUserByLogin(givenLogin);

        givenPassword = DigestUtils.md5Hex(givenPassword).toUpperCase();

        if (userWithGivenLogin != null){
            if (givenPassword.equals(userWithGivenLogin.getHashPassword())){
                HttpSession session = req.getSession();
                session.setAttribute("loggedUser", userWithGivenLogin);
            }
        } else{
            req.setAttribute("loginError",new String("Username does not exist, or password does not match"));
        }
        req.getRequestDispatcher("/login.jsp").forward(req,resp);

    }
}
