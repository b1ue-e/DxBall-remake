package Map;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

import Demension2D.Position;
import Objects.Ball;
import Objects.Block;
import Objects.Board;
import Objects.Objects;
import Objects.Wall;


/*public class Panels extends JPanel {
	//public Map map;
	private static final long serialVersionUID = 1L;
	static Board board = new Board(220,450);
//static Ball ball = new Ball(Map map,20, new Position(600, 900));
	static Image bjImg;
	static Toolkit tk = Toolkit.getDefaultToolkit();
	// 存储需要绘制的游戏对象
	ArrayList<Objects> gameBodyList = new ArrayList<Objects>();

	// 设置需要绘制的游戏对象
	public void setGameBodyList(ArrayList<Objects> gameBodyList) {
		this.gameBodyList = gameBodyList;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	//	private static final long serialVersionUID = 1L;
		// 设置画笔颜色
		//g.setColor(Color.BLUE);
		// 设置画笔大小
		//g.setFont(new Font(null, 0, 50));
		// 循环画出所有游戏对象
		for (Objects body : gameBodyList) {
		
			if (body instanceof Block) {
				//g.setColor(Color.CYAN);
				//x = body.getPosition().getX() - body.getLength() / 2;
				//y = body.getPosition().getY() - body.getWidth() / 2;
				//g.fillRect(x, y, body.getWidth(), body.getWidth());
				board.paint(g);
			}

			else if (body instanceof Block) {
				/*g.setColor(Color.RED);
				x = body.getPosition().getX() - body.getLength() / 2;
				y = body.getPosition().getY() - body.getWidth() / 2;
				g.fillRect(x, y, body.getWidth(), body.getWidth());*/
				
		//	}
			/*
			 * else if(body instanceof Drop) { g.setColor(Color.CYAN); x =
			 * body.getPosition().getX()-body.getLength()/2; y =
			 * body.getPosition().getY()-body.getWidth()/2; g.fillRect(x, y,
			 * body.getWidth(), body.getWidth());
			 * 
			 * }
			*/
			/*else if (body instanceof Ball) {
				/*Ball ball=(Ball) body;
				x = body.getPosition().getX() - ball.getR();
				y = body.getPosition().getY() - ball.getR();
				g.fillOval(x, y, body.getLength(), body.getWidth());*/
				//ball.paint(g);
				
				
		/*	}

		}
		
		
		

	}
}
*/