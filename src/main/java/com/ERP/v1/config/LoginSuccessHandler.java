package com.ERP.v1.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Implementation of Spring Security class to handle url mapping after login success;
public class LoginSuccessHandler implements AuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException{
        String role = authentication.getAuthorities().iterator().next().getAuthority();
        String redirectUrl;

        // role of the user is stored as "ROLE_<role_name>";
        if (role.equals("ROLE_ADMIN")) {
            redirectUrl = "/admin/dashboard";
        } else if (role.equals("ROLE_EMPLOYEE")) {
            redirectUrl = "/employee/dashboard";
        } else {
            redirectUrl = "/login?error";
        }

        response.sendRedirect(redirectUrl);
    }
    
}
