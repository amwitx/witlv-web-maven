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

		// ������ƣ���ʹ��
		response.setHeader("content-type", "text/html;charset=utf-8");
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
		response.getWriter().append(request.getRemotePort()+"");
		response.getWriter().append("<hr/>RemoteUser��");
		response.getWriter().append(request.getRemoteUser());
		response.getWriter().append("<hr/>����IP��ַ��");
		response.getWriter().append(request.getLocalAddr());
		response.getWriter().append("<hr/>���ؼ�������ƣ�");
		response.getWriter().append(request.getLocalName());
		response.getWriter().append("<hr/>����ʽ��");
		response.getWriter().append(request.getMethod());
		response.getWriter().append("<hr/>");
		//��ȡ����ͷ
		PrintWriter out=response.getWriter();
		Enumeration<String> requestHeader=request.getHeaderNames();
		out.write("��ȡ����Header");
		out.write("<hr/>");
		while (requestHeader.hasMoreElements())
		{
			//��ȡ��һԪ��
			String name = (String) requestHeader.nextElement();
			//��ȡ��Ӧ����ͷ��ֵ
			String value=request.getHeader(name);
			out.write(name+":"+value);
			out.write("<hr/>");
		}
		String accept="Accept-Encoding";
		out.write("��ȡ����"+accept);
		out.write("<hr/>");
		//��ȡAccept-Encoding����ͷ��Ӧ��ֵ
		String value=request.getHeader(accept);
		out.write(value);
		out.write("<hr/>");
		//��ȡĳ����ͷ���ϵ�ֵ
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
