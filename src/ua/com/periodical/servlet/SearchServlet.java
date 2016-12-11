package ua.com.periodical.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.periodical.model.Periodical;
import ua.com.periodical.service.PeriodicalService;
import ua.com.periodical.service.impl.PeriodicalServiceImpl;

/**
 * SearchServlet does search periodical by title and send it into list in
 * request Attribute;
 * 
 * @version 1.3 08.12.2016
 * @author Roman Grupskyi
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		if (title == null || title.equals("")) {
			setAttributeError(request);
		} else {
			PeriodicalService service = new PeriodicalServiceImpl();
			ArrayList<Periodical> list = new ArrayList<Periodical>();

			Periodical periodical = service.getPeriodicalByTitle(title);
			list.add(periodical);

			if (periodical == null) {
				setAttributeError(request);
			} else {
				request.setAttribute("list", list);
			}
		}
		request.getRequestDispatcher("/pages/Dashboard.jsp").forward(request, response);

	}

	private void setAttributeError(HttpServletRequest request) {
		request.setAttribute("info", "info");
		request.setAttribute("String", " OBJECT WITH THIS TITLE NOT FOUND!");
	}
}
