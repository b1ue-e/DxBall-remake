package Objects;

import java.util.Random;

import Demension2D.Position;
import Map.Map;
import Studio.MusicPlay;

public class BallSizeExchangeBox extends MagicBox{
	public int ballSizeExchangeBoxNum=0;
	boolean isCollision = false;
	public BallSizeExchangeBox(Map map, int length, int width, Position p) {
		super(map, length, width, p);
		// TODO Auto-generated constructor stub
	}
	public void runRt() {
		boxMove();
		boxBoardCollision();
		
	}
	public void boxBoardCollision() {
		boolean isCollision = false;
		if(Math.abs(map.board.getPosition().getX() - this.getPosition().getX()) <=(map.board.getLength()+this.getLength())/2 && Math.abs(map.board.getPosition().getY()-this.getPosition().getY())<=(map.board.getWidth()+this.getWidth())/2) {
			isCollision=true;
			Random r = new Random();
			//map.ball.setSpeed(5);
			if(r.nextInt(100)<=50) map.ball.setR(map.ball.getR()*2);
			else if (r.nextInt(100)>50) map.ball.setR(map.ball.getR()/2);
			this.map.destroy(this);
			ballSizeExchangeBoxNum++;
		}
		
	}
	
}
