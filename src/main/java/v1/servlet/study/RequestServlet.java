package v1.servlet.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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

		// 编码控制（好使）
		response.setHeader("content-type", "text/html;charset=utf-8");
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
		response.getWriter().append(request.getRemotePort()+"");
		response.getWriter().append("<hr/>RemoteUser：");
		response.getWriter().append(request.getRemoteUser());
		response.getWriter().append("<hr/>本地IP地址：");
		response.getWriter().append(request.getLocalAddr());
		response.getWriter().append("<hr/>本地计算机名称：");
		response.getWriter().append(request.getLocalName());
		response.getWriter().append("<hr/>请求方式：");
		response.getWriter().append(request.getMethod());
		response.getWriter().append("<hr/>");
		//获取请求头
		PrintWriter out=response.getWriter();
		Enumeration<String> requestHeader=request.getHeaderNames();
		out.write("获取所有Header");
		out.write("<hr/>");
		while (requestHeader.hasMoreElements())
		{
			//读取下一元素
			String name = (String) requestHeader.nextElement();
			//获取对应请求头的值
			String value=request.getHeader(name);
			out.write(name+":"+value);
			out.write("<hr/>");
		}
		String accept="Accept-Encoding";
		out.write("获取所有"+accept);
		out.write("<hr/>");
		//获取Accept-Encoding请求头对应的值
		String value=request.getHeader(accept);
		out.write(value);
		out.write("<hr/>");
		//获取某请求头集合的值
		Enumeration<String> accepts=request.getHeaders(accept);
		while (accepts.hasMoreElements())
		{
			String temp = (String) accepts.nextElement();
			System.out.println(temp);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
