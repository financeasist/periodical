package ua.com.periodical.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.security.validator.ValidatorException;
import ua.com.periodical.model.Periodical;
import ua.com.periodical.dao.MemoryRepository;

/**
 * Servlet: AddServlet retrieves periodical data from request, creates
 * periodical object and save him into ArrayList
 * 
 * @version 2.0 09.11.2016
 * @author Roman Grupskyi
 */
@WebServlet(urlPatterns = "/addToList", name = "AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddServlet() {
		super();
	}

	/**
	 * retrieves periodical data from request, creates Periodical object and 
	 * saves previosly created Periodical object in ArrayList collection 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
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

			response.getWriter().println("<html>");
			response.getWriter().println("<head>");
			response.getWriter().println("<title>addToList</title>");
			response.getWriter().println("</head>");
			response.getWriter().println("<body>");

			response.getWriter().println("new periodical added to List!");
			response.getWriter().println("</body>");
			response.getWriter().println("</html>");

		} catch (ValidatorException e) {
			e.printStackTrace();
		}
	}
/**
 * this method takes parameters and does validation. 
 * If values is not valid, shows on browser html page with appropriate message
 * @param request
 * @param fieldName
 * @param required
 * @param response
 * @return fieldValue
 * @throws ValidatorException
 * @throws IOException
 */
	public String getField(HttpServletRequest request, String fieldName, boolean required, HttpServletResponse response)
			throws ValidatorException, IOException {
		String fieldValue = request.getParameter(fieldName);
		if (fieldValue == null || fieldValue.trim().isEmpty()) {
			if (required) {
				response.getWriter().println("<html>");
				response.getWriter().println("<head>");
				response.getWriter().println("<title>addToList</title>");
				response.getWriter().println("</head>");
				response.getWriter().println("<body>");
				response.getWriter().println("PLEASE ENTER THE VALUE TO REQUIRED FIELDS! </br></br>"
						+ " required fields - 'id','title' and 'price'"+"</br>"
						+"all fields - 'id','title', 'price' and 'description' ");
				response.getWriter().println("</body>");
				response.getWriter().println("</html>");
				throw new ValidatorException(fieldValue);
			}
		}
		return fieldValue;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
