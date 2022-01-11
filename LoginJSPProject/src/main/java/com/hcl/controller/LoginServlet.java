package com.hcl.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hcl.model.LoginModel;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    protected void doPost(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException {
        //set MIME type
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        String username =  req.getParameter("uname");
        String password = req.getParameter("pwd");

        LoginModel model = new LoginModel();
        model.setUsername(username);
        model.setPassword(password);
        HttpSession session = req.getSession();
        session.setAttribute("abc", model);
        boolean status = model.validateLogin();

        if(status) {
            RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
            rd.forward(req, res);
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("failure.jsp");
            rd.forward(req, res);
        }
    }
}