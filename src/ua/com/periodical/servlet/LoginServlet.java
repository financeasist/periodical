package ua.com.periodical.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.com.periodical.model.User;
import ua.com.periodical.service.UserService;
import ua.com.periodical.service.impl.UserServiceImpl;

/**
 * This Servlret get email and password, does validation and checks was user
 * with this parameters registered or not. If not, send approproate message into
 * request Attribute, end forward to LoginError.jsp Otherwise, forward with
 * approproate message to Succses.jsp
 * 
 * @version 1.0 06.12.2016
 * @author Roman Grupskyi
 */
@WebServlet(urlPatterns = "/pages/LoginServlet", name = "LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String pwd = request.getParameter("password");

		UserService userService = new UserServiceImpl();
		User user = userService.getUserByUserNameAndPassword(userName, pwd);
		HttpSession session = request.getSession();
		if ((userName == null) || (userName == "")) {
			request.setAttribute("info", "info");
			request.getRequestDispatcher("LoginError.jsp").forward(request, response);
		} else {
			if (userService.IfUserExist(user)) {

				request.setAttribute("info", "succsessInfo");
				session.setAttribute("userName", userName);
				request.getRequestDispatcher("Succses.jsp").forward(request, response);
			} else {
				request.setAttribute("info", "info");
				request.setAttribute("email", "not null");
				request.setAttribute("String", "INVALID USER NAME OR PASSWORD! <a href='Login.jsp'>try again</a>");
				request.getRequestDispatcher("LoginError.jsp").forward(request, response);
			}
		}
	}

}
