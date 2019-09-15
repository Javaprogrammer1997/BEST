package com.hillel.hw22.servlets;

import com.hillel.hw22.person.Role;
import com.hillel.hw22.person.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/deleteFilms")
public class DeleteFilmsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        if (httpRequest.getMethod().equals("POST")) {

            User user = (User) session.getAttribute("user");

            if (user != null && user.getRole() == Role.ADMIN) {
                filterChain.doFilter(httpRequest, httpResponse);

            } else {
                httpResponse.sendRedirect("/login");
            }
        } else {
            filterChain.doFilter(httpRequest, httpResponse);
        }
    }
}