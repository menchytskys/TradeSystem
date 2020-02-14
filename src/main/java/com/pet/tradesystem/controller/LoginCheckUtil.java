package com.pet.tradesystem.controller;

import com.pet.tradesystem.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCheckUtil {

    static boolean isUserLoggedIn(HttpServletResponse response, HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (null == user) {
            try {
                response.sendRedirect(request.getContextPath() + "/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
}
