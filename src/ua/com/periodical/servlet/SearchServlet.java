package ua.com.periodical.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.periodical.dao.impl.MemoryRepositoryDaoImpl;
import ua.com.periodical.model.Periodical;

/**
 * SearchServlet search  periodical by title and send it into list in request Attribute;
 * 
 * @version 1.2 15.11.2016
 * @author Roman Grupskyi
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		MemoryRepositoryDaoImpl memoryRepositoryIinstance = MemoryRepositoryDaoImpl.getInstance();
		Periodical periodical = null;
		try {
			periodical = memoryRepositoryIinstance.getByTitle(title);
			System.out.println(periodical.toString());
		} catch (Exception e) {
			request.setAttribute("info", "info");
			request.setAttribute("String", " OBJECT WITH THIS TITLE NOT FOUND!");
		}
		ArrayList<Periodical> list = new ArrayList<Periodical>();
		list.add(periodical);

		if (title == null || title.equals("")) {
			request.setAttribute("info", "info");
			request.setAttribute("String", " OBJECT WITH THIS TITLE NOT FOUND!");
		} else {

			request.setAttribute("list", list);

		}
		request.getRequestDispatcher("/pages/Dashboard.jsp").forward(request, response);
		;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
