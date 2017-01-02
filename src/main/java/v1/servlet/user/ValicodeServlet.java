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
		
		//设置refresh响应头控制浏览器每隔5秒钟刷新一次
		response.setHeader("refresh", "5");
		// 在内存中创建一张图片
		BufferedImage image = new BufferedImage(70, 20, BufferedImage.TYPE_INT_BGR);
		// 得到图片绘制工具
		Graphics2D gra = (Graphics2D) image.getGraphics();
		// 设置背景
		gra.setColor(Color.WHITE);
		// 填充矩形
		gra.fillRect(0, 0, 70, 20);
		// 设置颜色
		gra.setColor(Color.blue);
		// 设置字体
		gra.setFont(new Font(null, Font.BOLD, 20));
		// 绘制字符
		gra.drawString(makeNum(), 2, 18);
		// 设置响应头控制浏览器浏览器以图片的方式打开，等同于response.setHeader("Content-Type",
		// "image/jpeg");
		response.setContentType("image/jpeg");
		// 设置响应头控制浏览器不缓存图片数据
		response.addDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Prama", "no-cache");
		// 输出图片
		ImageIO.write(image, "jpg", response.getOutputStream());

	}

	// 生成随机数
	private String makeNum()
	{
		// TODO 自动生成的方法存根
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
