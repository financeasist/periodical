package ua.com.periodical.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.periodical.model.Periodical;
import ua.com.periodical.dao.MemoryRepository;

/**
 * Servlet: AddServlet retrieves periodical data from request, creates
 * periodical object and save him into ArrayList
 * 
 * @version 1.0 09.11.2016
 * @author Roman Grupskyi
 */
@WebServlet(urlPatterns= "/addToList", name= "AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddServlet() {
		super();
	}

	/**
	 * retrieves periodical data from request and creates Periodical object
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		Double price = Double.parseDouble(request.getParameter("price"));
		String discription = request.getParameter("discription");

		Periodical periodical = new Periodical(id,title,price,discription);
		MemoryRepository.periodicals.add(periodical);
		
		response.getWriter().println("<html>");
		response.getWriter().println("<head>");
		response.getWriter().println("<title>addToList</title>");
		response.getWriter().println("</head>");
		response.getWriter().println("<body>");

		response.getWriter().println("new periodical added to List");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
