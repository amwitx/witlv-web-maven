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

		// �������
		response.setHeader("content-type", "text/html;charset=utf-8");

		// ��ȡcookie
		Cookie[] cookies = request.getCookies();
		// ��ǰʱ��
		Date currentDate = new Date(System.currentTimeMillis());
		if (cookies == null)
		{
			response.getWriter().append("���һ�η��ʱ�վ");
			// ����Cookie
			Cookie cookie = new Cookie("lastAccessTime", currentDate.toLocaleString());
			// ��������
			Cookie cookie1 = new Cookie("username", URLEncoder.encode("����¿", "UTF-8"));
			// ���ó�ʱʱ�䣨1�죩
			cookie.setMaxAge(1 * 60 * 60 * 24);
			cookie1.setMaxAge(1 * 60 * 60 * 24);
			// ���
			response.addCookie(cookie);
			response.addCookie(cookie1);
		} else
		{
			// ��ȡcookie����
			for (int i = 0; i < cookies.length; i++)
			{
				Cookie cookie = cookies[i];
				response.getWriter().append(MessageFormat.format("{0}={1}", cookie.getName(), cookie.getValue()));
				response.getWriter().append("<hr/>");
				// ��ȡ����
				response.getWriter().append(MessageFormat.format("{0}={1}", cookie.getName(),
						URLDecoder.decode(cookie.getValue(), "UTF-8")));
				response.getWriter().append("<hr/>");
			}
			// ɾ��Cookie
			Cookie cookie = new Cookie("lastAccessTime", currentDate.toLocaleString());
			Cookie cookie1 = new Cookie("username", URLEncoder.encode("����¿", "UTF-8"));
			// ���ó�ʱʱ�䣨0��
			cookie.setMaxAge(0);
			cookie1.setMaxAge(0);
			// ���
			response.addCookie(cookie);
			response.addCookie(cookie1);
		}
		response.getWriter().append("<hr/>");

		// ��ȡsession����
		HttpSession session = request.getSession();
		// ��������
		session.setAttribute("data", "����¿");
		// ��ȡsessionid
		String serssionId = session.getId();
		// �ж�session�ǲ����´�����
		if (session.isNew())
		{
			response.getWriter().append("session�����ɹ���sessionid�ǣ�" + serssionId);
		} else
		{
			response.getWriter().append("�������Ѿ����ڸ�session�ˣ�sessionid�ǣ�" + serssionId);
			session.invalidate();
		}
		response.getWriter().append("<hr/>");

		// ��ȡ����
		String id = request.getParameter("id");
		response.getWriter().append("id=" + id);
		response.getWriter().append("<hr/>�����URL��ַ��");
		response.getWriter().append(request.getRequestURL());
		response.getWriter().append("<hr/>�������Դ��");
		response.getWriter().append(request.getRequestURI());
		response.getWriter().append("<hr/>�����URL��ַ�и����Ĳ�����");
		response.getWriter().append(request.getQueryString());
		response.getWriter().append("<hr/>PathInfo��");
		response.getWriter().append(request.getPathInfo());
		response.getWriter().append("<hr/>�����ߵ�IP��ַ��");
		response.getWriter().append(request.getRemoteAddr());
		response.getWriter().append("<hr/>�����ߵ���������");
		response.getWriter().append(request.getRemoteHost());
		response.getWriter().append("<hr/>ʹ�õĶ˿ںţ�");
		response.getWriter().append(request.getRemotePort() + "");
		response.getWriter().append("<hr/>RemoteUser��");
		response.getWriter().append(request.getRemoteUser());
		response.getWriter().append("<hr/>����IP��ַ��");
		response.getWriter().append(request.getLocalAddr());
		response.getWriter().append("<hr/>���ؼ�������ƣ�");
		response.getWriter().append(request.getLocalName());
		response.getWriter().append("<hr/>����ʽ��");
		response.getWriter().append(request.getMethod());
		response.getWriter().append("<hr/>");
		// ��ȡ����ͷ
		PrintWriter out = response.getWriter();
		Enumeration<String> requestHeader = request.getHeaderNames();
		out.write("��ȡ����Header");
		out.write("<hr/>");
		while (requestHeader.hasMoreElements())
		{
			// ��ȡ��һԪ��
			String name = (String) requestHeader.nextElement();
			// ��ȡ��Ӧ����ͷ��ֵ
			String value = request.getHeader(name);
			out.write(name + ":" + value);
			out.write("<hr/>");
		}
		String accept = "Accept-Encoding";
		out.write("��ȡ����" + accept);
		out.write("<hr/>");
		// ��ȡAccept-Encoding����ͷ��Ӧ��ֵ
		String value = request.getHeader(accept);
		out.write(value);
		out.write("<hr/>");
		// ��ȡĳ����ͷ���ϵ�ֵ
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
