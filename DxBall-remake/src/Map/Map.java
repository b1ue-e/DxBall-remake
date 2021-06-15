package Map;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Map {
public static void  getUI() {
	JFrame f=new JFrame();
		f.setTitle("DxBall-remake");
		f.setSize(600,300);	
		f.setLocation(600,400);
		f.setBackground(new Color(0,215,245));
		JPanel p=new JPanel(null);
		p.setBounds(30, 30, 30, 30);		
		p.setBackground(new Color(123,21,41));
		f.add(p);
		f.setVisible(true);
}
}
