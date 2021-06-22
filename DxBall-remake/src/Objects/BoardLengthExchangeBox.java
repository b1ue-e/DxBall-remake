package Objects;

import java.util.Random;

import Demension2D.Position;
import Map.Map;

public class BoardLengthExchangeBox extends MagicBox{
	public int boardSizeExchangeBoxNum=0;
	boolean isCollision = false;
	public BoardLengthExchangeBox(Map map, int length, int width, Position p) {
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
			if(r.nextInt(300)<=50) map.board.setLength(map.board.getLength()*2);
			else if (r.nextInt(300)<=100) map.board.setLength(map.board.getLength()*4);
			else if(r.nextInt(300)<=150) map.board.setLength(map.board.getLength()*8);
			else if(r.nextInt(300)<=200) map.board.setLength(map.board.getLength()/2);
			else if(r.nextInt(300) <=250)map.board.setLength(map.board.getLength()/4);
			else if(r.nextInt(300) <=300) map.board.setLength(map.board.getLength()/8);
			this.map.destroy(this);
			boardSizeExchangeBoxNum++;
		}
		
	
	}
}
