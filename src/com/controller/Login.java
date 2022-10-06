package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1820121199591919757L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = null;
		
		if(request.getParameter("userID").equals("abhi") && request.getParameter("password").equals("abhi123")) {
			HttpSession session = request.getSession();
			session.setAttribute("user", request.getParameter("userID"));
			//response.sendRedirect("success.jsp");
			dispatcher = request.getRequestDispatcher("success.jsp");
			dispatcher.forward(request, response);
		}
		else {
			dispatcher = request.getRequestDispatcher("failure.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("failure.jsp");
		}
	}

}
