package Map;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import Map.Map.Panels;

public class BackgroundPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	// 最开始必须先画出游戏背景图片
	// 加载图片到我们的类中
	// Image类，就是图片类
	static Image bjImg;

	// Toolkit工具包类，可以创建图片
	static Toolkit tk = Toolkit.getDefaultToolkit();

	// 在静态块中，创建图片
	static {
		bjImg = tk.createImage(BackgroundPanel.class.getClassLoader().getResource("3.jpg"));
	}
	// 在面板上画出游戏背景图片
	public void paint(Graphics g) {
		super.paint(g);
		
		
		// 画游戏背景(你要画的图片，坐标x，坐标y，画出图片的宽度，想画多高，通知对象)
		g.drawImage(bjImg, 0, 0, 200, 50, null);
		
	}
}