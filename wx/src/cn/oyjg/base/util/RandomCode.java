package cn.oyjg.base.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RandomCode {

	/**
	 * 生成随机数图片
	 */
	public static void getRandcode(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.setProperty("java.awt.headless", "true");
		HttpSession session = request.getSession();
		int width = 60, height = 22;// 设置图片大小
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.fillRect(1, 1, width, height);// 设定边框
		g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
		g.setColor(getRandColor(111, 133, random));
		// 产生随机线
		for (int i = 0; i < 10; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(13);
			int yl = random.nextInt(15);
			g.drawLine(x, y, x + xl, y + yl);
		}
		// 产生随机点
		g.setColor(getRandColor(130, 150, random));
		// 产生5个随机数
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			g.setFont(getsFont(random));
			g.setColor(new Color(random.nextInt(101), random.nextInt(111),
					random.nextInt(121)));
			String rand = String.valueOf(getRandomString(random.nextInt(62)));
			sRand += rand;
			g.translate(random.nextInt(3), random.nextInt(3));
			g.drawString(rand, 13 * i, 16);
		}
		session.removeAttribute("rand");
		session.setAttribute("rand", sRand.toUpperCase());
		g.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}
	
	private static String getRandomString(int num) {
		String randstring = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		return String.valueOf(randstring.charAt(num));
	}
	
	
	/**
	 * 随机取得一个字体
	 * 
	 * @param Random
	 *            random 随机数
	 * @return Font 返回一个新字体
	 */
	private static Font getsFont(Random random) {
		return new Font("Fixedsys", Font.CENTER_BASELINE, 18);
	}

	/**
	 * 返回一个随机颜色
	 * 
	 * @param int
	 *            fc 随机数
	 * @param int
	 *            bc 随机数
	 * @param Random
	 *            random 随机数
	 * @return Color 返回一个新颜色
	 */
	private static Color getRandColor(int fc, int bc, Random random) {
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc - 6);
		int g = fc + random.nextInt(bc - fc - 4);
		int b = fc + random.nextInt(bc - fc - 8);
		return new Color(r, g, b);
	}

}