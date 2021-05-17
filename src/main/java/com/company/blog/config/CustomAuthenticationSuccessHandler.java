package com.company.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains("ROLE_ADMIN")) {
            httpServletResponse.sendRedirect("/AdminHome");
        } else if (roles.contains("ROLE_STAFF")) {
            httpServletResponse.sendRedirect("/StaffAccount");
        } else if (roles.contains("ROLE_CLIENT")) {
            httpServletResponse.sendRedirect("/MyAccount");
        }
    }
}
//    String targetUrl = "/";
//        if(role.contains("CLIENT")) {
//                targetUrl = "/MyAccount";
//                } else if(role.contains("STAFF")) {
//                targetUrl = "/StaffAccount";
//                } else if(role.contains("ADMIN")) {
//                targetUrl = "/AdminHome";
//                }
//                return targetUrl;