package ua.com.periodical.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.com.periodical.model.User;
import ua.com.periodical.service.PeriodicalService;
import ua.com.periodical.service.UserService;
import ua.com.periodical.service.impl.PeriodicalServiceImpl;
import ua.com.periodical.service.impl.UserServiceImpl;

/**
 * This Servlet removes periodical from memory repository by id and redirects to
 * PeriodicalListServlet with appropriate success/error message.
 * 
 * @version 1.2 23.11.2016
 * @author Roman Grupskyi
 */
@WebServlet(urlPatterns = "/pages/RemoveServlet", name = "RemoveServlet")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PeriodicalService periodicalService = new PeriodicalServiceImpl();
		UserService userService = new UserServiceImpl();

		String id = (String) request.getParameter("id");
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		User user = userService.getUserByEmail(userName);

		String succsessUrl = "../pages/periodicalList?key1=info&value1=succsessInfo&key2=String&value2=PERIODICAL WAS SUCCSESSFULLY REMOVED FROM lIST!";
		String errorUrl = "../pages/periodicalList?key1=info&value1=info&key2=String&value2=ERROR!OBJECT NOT FOUND!";
		boolean isSuccsess = true;
		try {
			Integer idInt = Integer.parseInt(id);
			periodicalService.removePeriodicalById(idInt, user);
		}catch (IllegalArgumentException ie) {
			isSuccsess = false;
			errorUrl =  "../pages/periodicalList?key1=info&value1=info&key2=String&value2=YOU DO NOT HAVE ENOUGH RIGHTS TO DO THIS OPERATION!";

		}
//		catch (Exception e) {
//			isSuccsess = false;
//		}
		if (isSuccsess)
			response.sendRedirect(succsessUrl);
		else
			response.sendRedirect(errorUrl);

		/*
		 * why it is not working through forward() method!??
		 * 
		 * request.setAttribute("info", "succsessInfo");
		 * request.setAttribute("String",
		 * "PERIODICAL WAS SUCCSESSFULLY REMOVED FROM lIST!");
		 * request.getRequestDispatcher("/pages/periodicalList").forward(
		 * request, response);
		 * 
		 */
	}
}
