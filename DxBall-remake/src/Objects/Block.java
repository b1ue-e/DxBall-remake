package Objects;

import Demension2D.Position;

public class Block extends Objects{
	
	public Block(int length,int width,Position p){
		this.length = length;
		this.width = width;
		this.p = p;
	}

	@Override
	public void runRt() {
		// TODO Auto-generated method stub
		BallBockCollision();
	}
	public void BallBockCollision() {
		boolean isCollision = false;
		if(map.ball.getPosition().getY() == this.getPosition().getY()-(this.width+map.ball.getR())/2) {
			isCollision = true;
			map.ball.getPosition().setDirY(-1);
			destroy(this);
		}
		if(map.ball.getPosition().getX()>= this.getPosition().getX() && isCollision == true) {
			map.ball.getPosition().setDirX(1);
		}else if(isCollision == true) {
			map.ball.getPosition().setDirX(-1);
			
		}
	}

	private void destroy(Objects obj) {
		// TODO Auto-generated method stub
		map.destroy(this);
	}
}
