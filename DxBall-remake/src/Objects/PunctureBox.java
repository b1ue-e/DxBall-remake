package Objects;

import Demension2D.Position;
import Map.Map;

public class PunctureBox extends MagicBox{
	public int PunctureBoxNum=0;
	public PunctureBox(Map map, int length, int width, Position p) {
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
			isCollision = true;
			map.ball.setPunctureEffect(true);
			this.map.destroy(this);
			PunctureBoxNum++;
			
		}
		
	}
	
	
} 