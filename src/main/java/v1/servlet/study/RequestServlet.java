package v1.servlet.study;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestServlet
 */
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append(request.getRequestURL());		
		response.getWriter().append("<hr/>");
		response.getWriter().append(request.getRequestURI());
		response.getWriter().append("<hr/>");
		response.getWriter().append(request.getQueryString());
		response.getWriter().append("<hr/>");
		response.getWriter().append(request.getPathInfo());
		response.getWriter().append("<hr/>");
		response.getWriter().append(request.getRemoteAddr());
		response.getWriter().append("<hr/>");
		response.getWriter().append(request.getRemoteHost());
		response.getWriter().append("<hr/>");
		response.getWriter().append(request.getRemotePort()+"");
		response.getWriter().append("<hr/>");
		response.getWriter().append(request.getRemoteUser());
		response.getWriter().append("<hr/>");
		response.getWriter().append(request.getLocalAddr());
		response.getWriter().append("<hr/>");
		response.getWriter().append(request.getLocalName());
		response.getWriter().append("<hr/>");
		response.getWriter().append(request.getMethod());
		response.getWriter().append("<hr/>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
