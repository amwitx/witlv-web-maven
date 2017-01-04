package v1.servlet.user;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Map;

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

		// 客户端是以UTF-8编码提交表单数据的，所以需要设置服务器端以UTF-8的编码进行接收，否则对于中文数据就会产生乱码
		response.setCharacterEncoding("UTF-8");
		// 编码控制
		response.setHeader("content-type", "text/html;charset=utf-8");
		// 读取form参数
		String valicode = request.getParameter("valicode");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		sex = new String(sex.getBytes("ISO8859-1"), "UTF-8");
		String depart = request.getParameter("depart");
		String[] roles = request.getParameterValues("role");
		String role = "";
		for (int i = 0; i < roles.length; i++)
		{
			role += roles[i];
			if (i < roles.length - 1)
				role += ",";
		}
		// 批量获取表单值
		Enumeration<String> paras = request.getParameterNames();
		while (paras.hasMoreElements())
		{
			String name = (String) paras.nextElement();
			String temp = request.getParameter(name);
			System.out.println(MessageFormat.format("{0}={1}", name, temp));
		}
		System.out.println("");
		// 获取值映射集合
		Map<String, String[]> paramMap = request.getParameterMap();
		// 映射集合
		for (Map.Entry<String, String[]> entry : paramMap.entrySet())
		{
			String paramName = entry.getKey();
			String paramValue = "";
			// 获取多值
			String[] paramValueArr = entry.getValue();
			// 判断数组值
			for (int i = 0; paramValueArr != null && i < paramValueArr.length; i++)
			{
				paramValue += paramValueArr[i];
				if (i < paramValueArr.length - 1)
				{
					paramValue += ",";
				}
			}
			System.out.println(MessageFormat.format("{0}={1}", paramName, paramValue));
		}

		// 设置服务器端以UTF-8编码输出数据到客户端
		response.setCharacterEncoding("UTF-8");
		// 设置客户端浏览器以UTF-8编码解析数据
		response.setHeader("content-type", "text/html;charset=utf-8");
		String output = "username={0},password={1},valicode={2},depart={3},role={4},sex={5}";
		response.getWriter().write(MessageFormat.format(output, username, password, valicode, depart, role, sex));
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
