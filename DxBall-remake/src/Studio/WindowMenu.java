package Studio;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Map.BackgroundPanel;


public class WindowMenu extends JFrame implements ActionListener {
	public boolean gameOn = false;
	int centerx = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2;
	int centery = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2;
	private BackgroundPanel panel;
	public WindowMenu() {
		// 窗口设置
		JLayeredPane pane = new JLayeredPane();
		this.setTitle("DxBall-remake");
		this.setSize(1000, 500);
		this.setLocation(centerx - 500, centery - 250);
		this.setLayout(new BorderLayout());
		this.setLayeredPane(pane);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.panel = new BackgroundPanel();  
        this.add(this.panel);
		int bw = 200;
		int bh = 50;
		JButton b = new JButton("开始游戏!");
		b.setOpaque(false);
		b.addActionListener(this);
		b.setBounds(centerx / 2, centery / 2, bw, bh);

		pane.add(b, JLayeredPane.MODAL_LAYER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MusicPlay.startMusic("button");
		this.setVisible(false);
		gameOn = true;
	
		
	}

}