package v1.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		// String data = "ÄãºÃ£¬RegServlet";
		// response.setHeader("content-type", "text/html;charset=utf-8");
		// response.getWriter().append(data);
		// response.getWriter().append("<hr/>");
		// OutputStream stream = response.getOutputStream();
		// stream.write(data.getBytes("utf-8"));
		// Ìø×ª
		// response.sendRedirect("LoginServlet");

		ServletContext context = this.getServletContext();
		String id = request.getParameter("id");
		RequestDispatcher rd = context.getRequestDispatcher("/LoginServlet?id=" + id);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
