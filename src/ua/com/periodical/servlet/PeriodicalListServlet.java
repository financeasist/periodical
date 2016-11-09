package ua.com.periodical.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.periodical.dao.MemoryRepository;
import ua.com.periodical.model.Periodical;

/**
 * Gets 'periodicals' ArrayList from 'ua.com.periodical.dao.MemoryRepository'
 * and shows it on brouser
 */
@WebServlet(urlPatterns = "/periodicalList", name= "PeriodicalListServlet")
public class PeriodicalListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PeriodicalListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<Periodical> list = MemoryRepository.getPeriodicals();
		
		response.getWriter().println("<html>");
		response.getWriter().println("<head>");
		response.getWriter().println("<title>Periodicals List</title>");
		response.getWriter().println("</head>");
		response.getWriter().println("<body>");

		response.getWriter().println("List contains : " + list.toString());
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
