package ua.com.periodical.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.periodical.dao.MemoryRepository;
import ua.com.periodical.model.Periodical;

/**
 * Gets 'periodicals' ArrayList from 'ua.com.periodical.dao.MemoryRepository'
 * and shows in a table on browser
 * 
 * @version 1.2 09.11.2016
 * @author Roman Grupskyi
 */
@WebServlet(urlPatterns = "/pages/periodicalList", name = "PeriodicalListServlet")
public class PeriodicalListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PeriodicalListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemoryRepository memoryRepositoryIinstance = MemoryRepository.getInstance();
		ArrayList<Periodical> list = memoryRepositoryIinstance.getPeriodicals();
		
		if(list.isEmpty()) {
			request.setAttribute("emptyString", "List is empty!");
		}
		else
		{
			request.setAttribute("list", list);
		}
		RequestDispatcher reqDispatcher= request.getServletContext().getRequestDispatcher("/pages/Dashboard.jsp");
		reqDispatcher.forward(request, response);
		}

	
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemoryRepository memoryRepositoryIinstance = MemoryRepository.getInstance();
		ArrayList<Periodical> list = memoryRepositoryIinstance.getPeriodicals();
		
//		response.getWriter().println("<html>");
//		response.getWriter().println("<head>");
//		response.getWriter().println("<title>Periodicals List</title>");
//		response.getWriter().println("</head>");
//		response.getWriter().println("<body>");
//		response.getWriter().println("<center>");
//		response.getWriter().println("<table border='1' width='30%' cellpadding='5'>");
//		response.getWriter().println("<thead>");
//		response.getWriter().println("<tr>");
//		response.getWriter().println("<th colspan='6'>Periodicals List</th>");
//		response.getWriter().println("</tr>");
//		response.getWriter().println("</thead>");
//		response.getWriter().println("<tr>");
//		response.getWriter().println("<td>id</td>");
//		response.getWriter().println("<td>title</td>");
//		response.getWriter().println("<td>price</td>");
//		response.getWriter().println("<td>description</td>");
//		response.getWriter().println("<td>isAdded</td>");
//		response.getWriter().println("<td>isPaided</td>");
//		response.getWriter().println("</tr>");
//		
//		if(list.isEmpty()) {
//			request.setAttribute("emptytring", "List is empty!");
//		}
//		else
//		for (Periodical periodical : list) {
//			response.getWriter().println("<tr>"+periodical.toString()+"</tr>");
//		}
//		response.getWriter().println("</body>");
//		response.getWriter().println("</html>");
	}

	

}
