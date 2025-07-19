package com.faith.oneUmmah.filter;

import com.faith.oneUmmah.util.SecurityContext;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.stream.Stream;


@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {
    private static final String[] ALLOWED_CONTENTS
            = {".css", ".js", ".jpg", ".png", "home", "login", "signup"};


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestURI = httpServletRequest.getRequestURI();

        boolean allowed = Stream.of(ALLOWED_CONTENTS).anyMatch(requestURI::contains);

        if(requestURI.equals("/") || allowed || SecurityContext.isAuthenticated(httpServletRequest)) {
            chain.doFilter(request,response);
        } else {
            ((HttpServletResponse) response).sendRedirect("/login");
        }
    }
}
