package ua.com.periodical.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is Servlet, which takes two numerals from request and shows their summ, div, mult.. ect on
 * browser
 */
@WebServlet(urlPatterns = "/summ", name = "ServletSumm")
public class ServletSumm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletSumm() {
		super();
	}

	/**
	 * takes two numerals from request and sent they summ, div, mult.. ect in
	 * responce
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int firstNumber = Integer.parseInt((String) request.getParameter("firstNumber"));
		int secondNumber = Integer.parseInt((String) request.getParameter("secondNumber"));
		int add = firstNumber + secondNumber;
		int subtract = firstNumber - secondNumber;
		int divide = firstNumber / secondNumber;
		int multiply = firstNumber * secondNumber;

		response.getWriter().println("<html>");
		response.getWriter().println("<head>");
		response.getWriter().println("<title>This is response!</title>");
		response.getWriter().println("</head>");
		response.getWriter().println("<body>");

		response.getWriter().println("The summ is : " + add);
		response.getWriter().println("<br>The subtract is : " + subtract);
		response.getWriter().println("The divide is : " + divide);
		response.getWriter().println("The multiply is : " + multiply);
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
