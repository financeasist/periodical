package ua.com.periodical.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.security.validator.ValidatorException;
import ua.com.periodical.model.Periodical;
import ua.com.periodical.dao.MemoryRepository;

/**
 * In doGet method -  AddServlet just send redirect to Add.jsp.
 * In doPost method -  AddServlet retrieves periodical data from request, does validation, creates
 * periodical object and save him into ArrayList. If process was succsessfull - sents appropriate message to Add.jsp
 * else sent error message.
 * 
 * @version 2.1 23.11.2016
 * @author Roman Grupskyi
 */
@WebServlet(urlPatterns = "/pages/AddServlet", name = "AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Retrieves periodical data from request, creates Periodical object and
	 * saves previosly created Periodical object in ArrayList collection
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.sendRedirect("Add.jsp");
		
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = getField(request, "id", true, response);
			String title = getField(request, "title", true, response);
			String price = getField(request, "price", true, response);
			String discription = getField(request, "description", false, response);

			Integer idInt = Integer.parseInt(id);
			Double priceD = Double.parseDouble(price);

			Periodical periodical = new Periodical(idInt, title, priceD, discription);
			MemoryRepository memoryRepositoryIinstance = MemoryRepository.getInstance();
			memoryRepositoryIinstance.addPeriodical(periodical);
			
			request.setAttribute("info", "succsessInfo");
			request.setAttribute("String", "NEW PERIODICAL ADDED TO lIST!");
			RequestDispatcher reqDispatcher= request.getServletContext().getRequestDispatcher("/pages/Add.jsp");
			reqDispatcher.forward(request, response);


		} catch (ValidatorException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method takes parameters and does validation. If values is not valid,
	 * sents on Add.jsp page appropriate message
	 * 
	 * @param request
	 * @param fieldName
	 * @param required
	 * @param response
	 * @return fieldValue
	 * @throws ValidatorException
	 * @throws IOException
	 * @throws ServletException 
	 */
	private String getField(HttpServletRequest request, String fieldName, boolean required,
			HttpServletResponse response) throws ValidatorException, IOException, ServletException {
		String fieldValue = request.getParameter(fieldName);
		if (fieldValue == null || fieldValue.trim().isEmpty()) {
			if (required) {
				request.setAttribute("info", "errorInfo");
				request.setAttribute("String", "PLEASE ENTER THE VALUE TO REQUIRED FIELDS!");
				RequestDispatcher reqDispatcher= request.getServletContext().getRequestDispatcher("/pages/Add.jsp");
				reqDispatcher.forward(request, response);

				throw new ValidatorException(fieldValue);
			}
		}
		return fieldValue;
	}
}
