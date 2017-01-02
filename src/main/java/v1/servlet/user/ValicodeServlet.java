package v1.servlet.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ValicodeServlet
 */
public class ValicodeServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValicodeServlet()
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
		
		//����refresh��Ӧͷ���������ÿ��5����ˢ��һ��
		response.setHeader("refresh", "5");
		// ���ڴ��д���һ��ͼƬ
		BufferedImage image = new BufferedImage(70, 20, BufferedImage.TYPE_INT_BGR);
		// �õ�ͼƬ���ƹ���
		Graphics2D gra = (Graphics2D) image.getGraphics();
		// ���ñ���
		gra.setColor(Color.WHITE);
		// ������
		gra.fillRect(0, 0, 70, 20);
		// ������ɫ
		gra.setColor(Color.blue);
		// ��������
		gra.setFont(new Font(null, Font.BOLD, 20));
		// �����ַ�
		gra.drawString(makeNum(), 2, 18);
		// ������Ӧͷ����������������ͼƬ�ķ�ʽ�򿪣���ͬ��response.setHeader("Content-Type",
		// "image/jpeg");
		response.setContentType("image/jpeg");
		// ������Ӧͷ���������������ͼƬ����
		response.addDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Prama", "no-cache");
		// ���ͼƬ
		ImageIO.write(image, "jpg", response.getOutputStream());

	}

	// ���������
	private String makeNum()
	{
		// TODO �Զ����ɵķ������
		Random random = new Random();
		String num = random.nextInt(999999) + "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 6 - num.length(); i++)
		{
			sb.append("0");
		}
		num = sb.toString() + num;
		return num;
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
