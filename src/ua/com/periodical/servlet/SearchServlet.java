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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		MemoryRepository memoryRepositoryIinstance = MemoryRepository.getInstance();
		Periodical periodical = memoryRepositoryIinstance.getByTitle(title);
		try{
			System.out.println(periodical.toString());
		}catch(Exception e){
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
