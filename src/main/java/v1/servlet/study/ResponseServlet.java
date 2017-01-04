package v1.servlet.study;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseServlet
 */
public class ResponseServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResponseServlet()
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

		// 编码控制（好使）
		response.setHeader("content-type", "text/html;charset=utf-8");
		//设置将字符以"UTF-8"编码输出到客户端浏览器（不好使）
		response.setCharacterEncoding("UTF-8");
		// 输出文本
		String data = "你好，Servlet";
		//在开发过程中，如果希望服务器输出什么浏览器就能看到什么，那么在服务器端都要以字符串的形式进行输出
		PrintWriter out = response.getWriter();
		//response.getWriter().append(data);
		//使用PrintWriter流向客户端输出字符
		out.write(data);
		// response.getWriter();与response.getOutputStream();不能并存
		// OutputStream outputStream = response.getOutputStream();
		//将字符转换成字节数组，指定以UTF-8编码进行转换
		// response.getOutputStream().write(data.getBytes("utf-8"));
		// outputStream.write(1);输出无效
		// outputStream.write((1 + "").getBytes());
		response.getWriter().append("<hr/>");
		// 读取参数
		String id = request.getParameter("id");
		response.getWriter().append("id=" + id);
		// 输出控制台
		System.out.print(data + id);
		try
		{
			// 读取资源包配置文件
			ResourceBundle resource = ResourceBundle.getBundle("v1/db/config/db");
			String driver1 = resource.getString("jdbc.driver");
			String url2 = resource.getString("jdbc.url");
			String username2 = resource.getString("jdbc.username");
			String password2 = resource.getString("jdbc.password");
			// 字符串格式化方法1
			String connectionString = String.format("driver=%s,url=%s,username=%s,password%s", driver1, url2, username2,
					password2);
			response.getWriter().append(connectionString);
			response.getWriter().append("<hr/>");

			// 使用servletContext读取资源文件
			ServletContext context = this.getServletContext();
			Properties props = new Properties();
			InputStream stream = context.getResourceAsStream("/WEB-INF/classes/v1/db/config/db.properties");
			props.load(stream);
			String driver = props.getProperty("jdbc.driver");
			String url = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");
			// 字符串格式化方法2
			response.getWriter().append(MessageFormat.format("driver={0},url={1},username={2},password{3}", driver, url,
					username, password));
			// 客户端缓存（1天）
			response.setDateHeader("expires", System.currentTimeMillis() + 1000 * 60 * 60 * 24);
			// 禁止缓存当前页面
			response.setDateHeader("expries", -1);
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");
			// 异常
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
