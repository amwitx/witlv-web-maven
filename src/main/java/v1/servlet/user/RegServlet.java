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

		// �ͻ�������UTF-8�����ύ�����ݵģ�������Ҫ���÷���������UTF-8�ı�����н��գ���������������ݾͻ��������
		response.setCharacterEncoding("UTF-8");
		// �������
		response.setHeader("content-type", "text/html;charset=utf-8");
		// ��ȡform����
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
		// ������ȡ��ֵ
		Enumeration<String> paras = request.getParameterNames();
		while (paras.hasMoreElements())
		{
			String name = (String) paras.nextElement();
			String temp = request.getParameter(name);
			System.out.println(MessageFormat.format("{0}={1}", name, temp));
		}
		System.out.println("");
		// ��ȡֵӳ�伯��
		Map<String, String[]> paramMap = request.getParameterMap();
		// ӳ�伯��
		for (Map.Entry<String, String[]> entry : paramMap.entrySet())
		{
			String paramName = entry.getKey();
			String paramValue = "";
			// ��ȡ��ֵ
			String[] paramValueArr = entry.getValue();
			// �ж�����ֵ
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

		// ���÷���������UTF-8����������ݵ��ͻ���
		response.setCharacterEncoding("UTF-8");
		// ���ÿͻ����������UTF-8�����������
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
