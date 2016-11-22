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
 * Servlet implementation class RemoveServlet
 */
@WebServlet(urlPatterns = "/pages/RemoveServlet", name = "RemoveServlet")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemoryRepository memoryRepositoryIinstance = MemoryRepository.getInstance();
		ArrayList<Periodical> list = memoryRepositoryIinstance.getPeriodicals();
		String id = (String) request.getAttribute("id");
		String title = (String) request.getAttribute("title");
		String price = (String) request.getAttribute("price");
		String discription = (String) request.getAttribute("discription");
		Integer idInt = Integer.parseInt(id);
		Double priceD = Double.parseDouble(price);

		Periodical periodical = new Periodical(idInt, title, priceD, discription);
		list.remove(periodical);
		
		RequestDispatcher reqDispatcher= request.getServletContext().getRequestDispatcher("/pages/periodicalList");
		reqDispatcher.forward(request, response);
	}

}
