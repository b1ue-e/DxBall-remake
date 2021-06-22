package Objects;

import Map.Map;

import Demension2D.Position;
public class Wall extends Objects {
	private Map map;
	public Wall(Map map,int length,int width,Position p) {
		this.length = length;
		this.width = width;
		this.p = p;
		this.map = map;
	}

	@Override
	public void runRt() {
		// TODO ÇòºÍÇ½ÃæÅö×²
		WallBallCollision();
		
	}
	public void WallBallCollision() {
		int top = this.getPosition().getY() - this.width/2;
		int bottom = top + this.width;
		int left = this.getPosition().getX() - this.length/2;
		int right = left +this.length;
		if(Math.abs(map.ball.getPosition().getX()-left) <= map.ball.getR()) {
			map.ball.getPosition().setDirX(1);
		}else if(Math.abs(map.ball.getPosition().getX()+ map.ball.getR())>= right) {
			map.ball.getPosition().setDirX(-1);
		}else if(Math.abs(map.ball.getPosition().getY()- top) <=map.ball.getR() ) {
			map.ball.getPosition().setDirY(1);
		}/*else if(map.ball.getPosition().getY() + map.ball.getR() == bottom) {
			map.isGameOver();
		}*/
	}
	
}










