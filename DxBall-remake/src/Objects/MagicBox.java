package Objects;

import Demension2D.Position;
import Map.Map;
import Studio.MusicPlay;

public class MagicBox extends Objects{
	Map map;
	public MagicBox(Map map,int length,int width , Position p) {
		this.map = map;
		this.length = length;
		this.width = width;
		this.p = p;
		this.getPosition().setDirX(0);
		this.getPosition().setDirY(1);
	}
	@Override
	public void runRt() {
		// TODO Auto-generated method stub
		boxMove();
		boxBoardCollision();
	}
	public void boxBoardCollision() {
		boolean isCollision = false;
		if(Math.abs(map.board.getPosition().getX() - this.getPosition().getX()) <=(map.board.getLength()+this.getLength())/2 && Math.abs(map.board.getPosition().getY()-this.getPosition().getY())<=(map.board.getWidth()+this.getWidth())/2) {
			isCollision = true;
			this.map.destroy(this);
		}
	}
	public void boxMove() {
		this.setSpeed(2);
		this.getPosition().setX(this.getPosition().getX()+this.getSpeed()*this.getPosition().getDirX());
		this.getPosition().setY(this.getPosition().getY()+this.getSpeed()*this.getPosition().getDirY());
		
	}
	
}
