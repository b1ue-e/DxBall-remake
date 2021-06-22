package Map;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import Map.Map.Panels;

public class BackgroundPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	// �ʼ�����Ȼ�����Ϸ����ͼƬ
	// ����ͼƬ�����ǵ�����
	// Image�࣬����ͼƬ��
	static Image bjImg;

	// Toolkit���߰��࣬���Դ���ͼƬ
	static Toolkit tk = Toolkit.getDefaultToolkit();

	// �ھ�̬���У�����ͼƬ
	static {
		bjImg = tk.createImage(BackgroundPanel.class.getClassLoader().getResource("3.jpg"));
	}
	// ������ϻ�����Ϸ����ͼƬ
	public void paint(Graphics g) {
		super.paint(g);
		
		
		// ����Ϸ����(��Ҫ����ͼƬ������x������y������ͼƬ�Ŀ�ȣ��뻭��ߣ�֪ͨ����)
		g.drawImage(bjImg, 0, 0, 200, 50, null);
		
	}
}