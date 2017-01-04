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

		// ������ƣ���ʹ��
		response.setHeader("content-type", "text/html;charset=utf-8");
		//���ý��ַ���"UTF-8"����������ͻ��������������ʹ��
		response.setCharacterEncoding("UTF-8");
		// ����ı�
		String data = "��ã�Servlet";
		//�ڿ��������У����ϣ�����������ʲô��������ܿ���ʲô����ô�ڷ������˶�Ҫ���ַ�������ʽ�������
		PrintWriter out = response.getWriter();
		//response.getWriter().append(data);
		//ʹ��PrintWriter����ͻ�������ַ�
		out.write(data);
		// response.getWriter();��response.getOutputStream();���ܲ���
		// OutputStream outputStream = response.getOutputStream();
		//���ַ�ת�����ֽ����飬ָ����UTF-8�������ת��
		// response.getOutputStream().write(data.getBytes("utf-8"));
		// outputStream.write(1);�����Ч
		// outputStream.write((1 + "").getBytes());
		response.getWriter().append("<hr/>");
		// ��ȡ����
		String id = request.getParameter("id");
		response.getWriter().append("id=" + id);
		// �������̨
		System.out.print(data + id);
		try
		{
			// ��ȡ��Դ�������ļ�
			ResourceBundle resource = ResourceBundle.getBundle("v1/db/config/db");
			String driver1 = resource.getString("jdbc.driver");
			String url2 = resource.getString("jdbc.url");
			String username2 = resource.getString("jdbc.username");
			String password2 = resource.getString("jdbc.password");
			// �ַ�����ʽ������1
			String connectionString = String.format("driver=%s,url=%s,username=%s,password%s", driver1, url2, username2,
					password2);
			response.getWriter().append(connectionString);
			response.getWriter().append("<hr/>");

			// ʹ��servletContext��ȡ��Դ�ļ�
			ServletContext context = this.getServletContext();
			Properties props = new Properties();
			InputStream stream = context.getResourceAsStream("/WEB-INF/classes/v1/db/config/db.properties");
			props.load(stream);
			String driver = props.getProperty("jdbc.driver");
			String url = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");
			// �ַ�����ʽ������2
			response.getWriter().append(MessageFormat.format("driver={0},url={1},username={2},password{3}", driver, url,
					username, password));
			// �ͻ��˻��棨1�죩
			response.setDateHeader("expires", System.currentTimeMillis() + 1000 * 60 * 60 * 24);
			// ��ֹ���浱ǰҳ��
			response.setDateHeader("expries", -1);
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");
			// �쳣
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
