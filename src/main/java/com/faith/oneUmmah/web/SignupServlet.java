package com.faith.oneUmmah.web;

import com.faith.oneUmmah.dto.UserDTO;
import com.faith.oneUmmah.repository.UserRepositoryImpl;
import com.faith.oneUmmah.service.UserService;
import com.faith.oneUmmah.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(SignupServlet.class);

    private UserService userService = new UserServiceImpl(new UserRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        LOGGER.info("Serving Signup Page");
        req.getRequestDispatcher("WEB-INF/signup.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO userDTO = copyParametersTo(req);
        Map<String, String> errors = validate(userDTO);

        if(errors.isEmpty()){
            LOGGER.info("user is valid, creating a new user with : {}", userDTO);
            userService.saveUser(userDTO);
            resp.sendRedirect("/home");
        } else {
            LOGGER.info("user is invalid, data : {}", userDTO);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
        }
    }


    private UserDTO copyParametersTo(HttpServletRequest req) {

        var userDTO = new UserDTO();
        userDTO.setFirstName(req.getParameter("firstName"));
        userDTO.setLastName(req.getParameter("lastName"));
        userDTO.setPassword(req.getParameter("password"));
        userDTO.setConfirmPassword(req.getParameter("confirmPassword"));
        userDTO.setEmail(req.getParameter("email"));
        userDTO.setUsername(req.getParameter("username"));

        return userDTO;
    }

    private boolean isValid(UserDTO userDTO){
        return Validation
                .buildDefaultValidatorFactory()
                .getValidator()
                .validate(userDTO)
                .isEmpty();
    }

    private Map<String, String> validate(UserDTO userDTO) {

        Set<ConstraintViolation<UserDTO>> violations = Validation
                .buildDefaultValidatorFactory()
                .getValidator()
                .validate(userDTO);

        Map<String, String> errors = new HashMap<>();

        for (ConstraintViolation<UserDTO> violation : violations) {
            String path = violation.getPropertyPath().toString();

            if(errors.containsKey(path)) {
                errors.compute(path, (k, errorMassage) -> errorMassage + " <br/> " + violation.getMessage());
                //errors.put(path, errorMassage + " <br/> "+ violation.getMessage());
            }else{
                errors.put(path, violation.getMessage());
            }
        }

        return errors;
    }

}
