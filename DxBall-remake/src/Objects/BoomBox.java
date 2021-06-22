package Objects;

import Demension2D.Position;
import Map.Map;
import Studio.MusicPlay;

public class BoomBox extends MagicBox {
	public int BoomBoxNum=0;
	boolean isCollision = false;
	public BoomBox(Map map, int length, int width, Position p) {
		super(map, length, width, p);
		// TODO Auto-generated constructor stub
	}
	public void runRt() {
		boxMove();
		boxBoardCollision();
	}
	public void boxBoardCollision() {
		if(Math.abs(map.board.getPosition().getX() - this.getPosition().getX()) <=(map.board.getLength()+this.getLength())/2 && Math.abs(map.board.getPosition().getY()-this.getPosition().getY())<=(map.board.getWidth()+this.getWidth())/2) {
			isCollision = true;
			map.ball.setBoomEffect(true);
			this.map.destroy(this);
			BoomBoxNum++;
		}
		
	}
	
	
}
