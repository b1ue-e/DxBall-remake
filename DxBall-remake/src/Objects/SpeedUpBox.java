package Objects;

import Demension2D.Position;
import Map.Map;
import Studio.MusicPlay;

public class SpeedUpBox extends MagicBox{
	public int SpeedUpBoxNum=0;
	boolean isCollision = false;
	public SpeedUpBox(Map map, int length, int width, Position p) {
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
			map.ball.setSpeed(5);
			this.map.destroy(this);
			 SpeedUpBoxNum++;
			MusicPlay.startMusic("speedup");
		}
		
	}
	
	
}