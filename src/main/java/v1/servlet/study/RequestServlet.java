package v1.servlet.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RequestServlet
 */
public class RequestServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestServlet()
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

		// 编码控制
		response.setHeader("content-type", "text/html;charset=utf-8");

		// 读取cookie
		Cookie[] cookies = request.getCookies();
		// 当前时间
		Date currentDate = new Date(System.currentTimeMillis());
		if (cookies == null)
		{
			response.getWriter().append("你第一次访问本站");
			// 设置Cookie
			Cookie cookie = new Cookie("lastAccessTime", currentDate.toLocaleString());
			// 保存中文
			Cookie cookie1 = new Cookie("username", URLEncoder.encode("井中驴", "UTF-8"));
			// 设置超时时间（1天）
			cookie.setMaxAge(1 * 60 * 60 * 24);
			cookie1.setMaxAge(1 * 60 * 60 * 24);
			// 添加
			response.addCookie(cookie);
			response.addCookie(cookie1);
		} else
		{
			// 读取cookie集合
			for (int i = 0; i < cookies.length; i++)
			{
				Cookie cookie = cookies[i];
				response.getWriter().append(MessageFormat.format("{0}={1}", cookie.getName(), cookie.getValue()));
				response.getWriter().append("<hr/>");
				// 读取中文
				response.getWriter().append(MessageFormat.format("{0}={1}", cookie.getName(),
						URLDecoder.decode(cookie.getValue(), "UTF-8")));
				response.getWriter().append("<hr/>");
			}
			// 删除Cookie
			Cookie cookie = new Cookie("lastAccessTime", currentDate.toLocaleString());
			Cookie cookie1 = new Cookie("username", URLEncoder.encode("井中驴", "UTF-8"));
			// 设置超时时间（0）
			cookie.setMaxAge(0);
			cookie1.setMaxAge(0);
			// 添加
			response.addCookie(cookie);
			response.addCookie(cookie1);
		}
		response.getWriter().append("<hr/>");

		// 获取session对象
		HttpSession session = request.getSession();
		// 保存数据
		session.setAttribute("data", "井中驴");
		// 获取sessionid
		String serssionId = session.getId();
		// 判断session是不是新创建的
		if (session.isNew())
		{
			response.getWriter().append("session创建成功，sessionid是：" + serssionId);
		} else
		{
			response.getWriter().append("服务器已经存在该session了，sessionid是：" + serssionId);
			session.invalidate();
		}
		response.getWriter().append("<hr/>");

		// 读取参数
		String id = request.getParameter("id");
		response.getWriter().append("id=" + id);
		response.getWriter().append("<hr/>请求的URL地址：");
		response.getWriter().append(request.getRequestURL());
		response.getWriter().append("<hr/>请求的资源：");
		response.getWriter().append(request.getRequestURI());
		response.getWriter().append("<hr/>请求的URL地址中附带的参数：");
		response.getWriter().append(request.getQueryString());
		response.getWriter().append("<hr/>PathInfo：");
		response.getWriter().append(request.getPathInfo());
		response.getWriter().append("<hr/>来访者的IP地址：");
		response.getWriter().append(request.getRemoteAddr());
		response.getWriter().append("<hr/>来访者的主机名：");
		response.getWriter().append(request.getRemoteHost());
		response.getWriter().append("<hr/>使用的端口号：");
		response.getWriter().append(request.getRemotePort() + "");
		response.getWriter().append("<hr/>RemoteUser：");
		response.getWriter().append(request.getRemoteUser());
		response.getWriter().append("<hr/>本地IP地址：");
		response.getWriter().append(request.getLocalAddr());
		response.getWriter().append("<hr/>本地计算机名称：");
		response.getWriter().append(request.getLocalName());
		response.getWriter().append("<hr/>请求方式：");
		response.getWriter().append(request.getMethod());
		response.getWriter().append("<hr/>");
		// 获取请求头
		PrintWriter out = response.getWriter();
		Enumeration<String> requestHeader = request.getHeaderNames();
		out.write("获取所有Header");
		out.write("<hr/>");
		while (requestHeader.hasMoreElements())
		{
			// 读取下一元素
			String name = (String) requestHeader.nextElement();
			// 获取对应请求头的值
			String value = request.getHeader(name);
			out.write(name + ":" + value);
			out.write("<hr/>");
		}
		String accept = "Accept-Encoding";
		out.write("获取所有" + accept);
		out.write("<hr/>");
		// 获取Accept-Encoding请求头对应的值
		String value = request.getHeader(accept);
		out.write(value);
		out.write("<hr/>");
		// 获取某请求头集合的值
		Enumeration<String> accepts = request.getHeaders(accept);
		while (accepts.hasMoreElements())
		{
			String temp = (String) accepts.nextElement();
			System.out.println(temp);
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
