package ua.com.periodical.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.com.periodical.model.Periodical;
import ua.com.periodical.service.PeriodicalService;
import ua.com.periodical.service.impl.PeriodicalServiceImpl;

/**
 * In doGET method: Gets 'periodicals' ArrayList from
 * 'ua.com.periodical.dao.MemoryRepositoryDao' and check it. If list is empty,
 * then sents appropriate message, else sents that list into
 * 'pages/Dashboard.jsp'. Also this servlet takes and redirects to
 * 'pages/Dashboard.jsp' a request param from RemoveServlet.
 * 
 * @version 1.2 09.11.2016
 * @author Roman Grupskyi
 */
@WebServlet(urlPatterns = "/pages/periodicalList", name = "PeriodicalListServlet")
public class PeriodicalListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("userName") != null) {

			PeriodicalService service = new PeriodicalServiceImpl();
			List<Periodical> list = service.getAllPeriodicals();

			if (list.isEmpty()) {
				request.setAttribute("info", "info");
				request.setAttribute("String", "List is empty!");
			} else {

				request.setAttribute("list", list);

			}
			String key1 = request.getParameter("key1");
			String value1 = request.getParameter("value1");
			String key2 = request.getParameter("key2");
			String value2 = request.getParameter("value2");

			if ((key1 != null) && (key2 != null)) {
				request.setAttribute(key1, value1);
				request.setAttribute(key2, value2);
			}

			RequestDispatcher reqDispatcher = request.getServletContext().getRequestDispatcher("/pages/Dashboard.jsp");
			reqDispatcher.forward(request, response);
		} else
			response.sendRedirect("Login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
