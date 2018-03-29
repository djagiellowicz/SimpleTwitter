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
import java.io.IOException;

@WebServlet(urlPatterns = "/userRegistration")
public class UserRegistrationServlet extends HttpServlet {
    UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isLoginUnique = true;
        boolean isEmailUnique = true;
        boolean doesPasswordMatch = true;

        String login = req.getParameter("login").toLowerCase();
        String email = req.getParameter("email").toLowerCase();
        String password = req.getParameter("password");
        String passwordConf = req.getParameter("passwordConf");

        //TODO: In future it's possible to add Enum with error messages

        if (userDAO.getUserByLogin(login) != null){
            isLoginUnique = false;
            req.setAttribute("uniquelogin",false);
            //System.out.println("Unique login: " + isLoginUnique);
        }

        if (userDAO.getUserByEmail(email) != null){
            isEmailUnique = false;
            req.setAttribute("uniqueemail", false);
            //System.out.println("Unique email: " + isEmailUnique);

        }

        if (!password.equals(passwordConf)){
            doesPasswordMatch = false;
            req.setAttribute("passwordsmatch",false);
        }

        if (isLoginUnique && isEmailUnique && doesPasswordMatch){
            User newUser = new User();
            newUser.setLogin(login);
            newUser.setEmail(email);
            newUser.setHashPassword(DigestUtils.md5Hex(password).toUpperCase());
            userDAO.saveUser(newUser);
        }

        req.getRequestDispatcher("/registration.jsp").forward(req,resp);
    }
}
