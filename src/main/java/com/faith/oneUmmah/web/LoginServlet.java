package com.faith.oneUmmah.web;

import com.faith.oneUmmah.domain.User;
import com.faith.oneUmmah.dto.LoginDTO;
import com.faith.oneUmmah.exception.UserNotFoundException;
import com.faith.oneUmmah.repository.UserRepositoryImpl;
import com.faith.oneUmmah.service.UserService;
import com.faith.oneUmmah.service.UserServiceImpl;
import com.faith.oneUmmah.util.SecurityContext;
import com.faith.oneUmmah.util.ValidationUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);

    private final UserService userService = new UserServiceImpl(new UserRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        LOGGER.info("Serving login Page");
        req.getRequestDispatcher("WEB-INF/login.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        var loginDTO = new LoginDTO(req.getParameter("username"), req.getParameter("password"));
        LOGGER.info("Received login data: {}", loginDTO);

        var errors = ValidationUtil.getInstance().validate(loginDTO);

        if(!errors.isEmpty()) {
            LOGGER.info("Fail to login, sending to login form again");
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req,res);
        }

        login(loginDTO, req);
        LOGGER.info("Login successful, redirecting to home page");
        res.sendRedirect("/home");
    }


    private void login(LoginDTO loginDTO, HttpServletRequest req) throws UserNotFoundException {
        User user = userService.verifyUser(loginDTO);
        SecurityContext.login(req,user);
    }

}
