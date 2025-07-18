package com.faith.oneUmmah.util;

import com.faith.oneUmmah.domain.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SecurityContext {
    public static final String AUTHENTICATION_KEY = "auth.key";

    public static void login(HttpServletRequest request, User user) {
        HttpSession oldSession = request.getSession(false);
        if(oldSession != null) {
            oldSession.invalidate();
        }

        HttpSession session = request.getSession(true);
        session.setAttribute(AUTHENTICATION_KEY,user);
    }

    public static void logout(HttpServletRequest request) {
        request.getSession(true).removeAttribute(AUTHENTICATION_KEY);
    }

    public static User getCurrentUser(HttpServletRequest request) {
        return (User) request.getSession(true).getAttribute(AUTHENTICATION_KEY);
    }

    public static boolean isAuthenticated(HttpServletRequest request) {
        return request.getSession(true).getAttribute(AUTHENTICATION_KEY) != null;
    }
}
