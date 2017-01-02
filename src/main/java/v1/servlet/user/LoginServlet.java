package v1.servlet.user;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet()
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
		response.setHeader("content-type", "text/html;charset=utf-8");

		String data = "你好，LoginServlet";
		response.setHeader("content-type", "text/html;charset=utf-8");
		String id = request.getParameter("id");
		response.getWriter().append(data + ",id=" + id);
		response.getWriter().append("<hr/>");
		ServletContext context = this.getServletContext();
		Properties props = new Properties();
		try
		{
			// 读取配置文件
			ResourceBundle resource = ResourceBundle.getBundle("v1/db/config/db");
			response.getWriter().append(resource.getString("jdbc.driver"));
			response.getWriter().append(resource.getString("jdbc.url"));
			response.getWriter().append(resource.getString("jdbc.username"));
			response.getWriter().append(resource.getString("jdbc.password"));
			response.getWriter().append("<hr/>");

			InputStream stream = context.getResourceAsStream("/WEB-INF/classes/v1/db/config/db.properties");
			props.load(stream);
			String driver = props.getProperty("jdbc.driver");
			String url = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");

			response.getWriter().append(MessageFormat.format("driver={0},url={1},username={2},password{3}", driver, url,
					username, password));
			response.getWriter().append("<hr/>");
			response.getWriter().append("中国");
		} catch (Exception e)
		{
			// TODO: handle exception
			response.getWriter().append(e.getMessage());
		}
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
