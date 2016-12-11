package ua.com.periodical.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.periodical.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(urlPatterns = "/pages/RegisterServlet", name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserServiceImpl userService = new UserServiceImpl();
		if ((userName == null) || (userName.equals("") || (email == null) || (email.equals("")) || (password == null)
				|| (password.equals("")))) {
			request.setAttribute("info", "info");
			request.getRequestDispatcher("RegisterError.jsp").forward(request, response);
		} else {
			userService.addUser(userName, email, password);

			request.setAttribute("info", "succsessInfo");
			request.getRequestDispatcher("Welcome.jsp").forward(request, response);

		}
	}
}
