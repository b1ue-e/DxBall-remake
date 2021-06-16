package Objects;

import Demension2D.Position;

public class Ball extends Objects{
	int r;
	public Ball(int r) {
		this.length = r;
		this.width = r;
		this.r = r;
	}
	public Ball(int r,Position p) {
		this.length = r;
		this.width = r;
		this.r =r;
		this.p = p;
	}
	
	@Override
	public void runRt() {
		// TODO Ball move
		update();
	}
	public void update() {
		if(getSpeed()!=0) {
			this.p.x +=(p.getDirX()*getSpeed());
			this.p.y +=(p.getDirY()*getSpeed());
		}
	}
	
	/*写入map.java中
	 * public void isGameOver() {
		//TODO 球碰到下边界游戏结束
		if(this.getPosition().getX() == map.bottom) {
			gameOver = true;
		}
	}*/
	
	public int getR() {
		// TODO Auto-generated method stub
		return this.r;
	}














}


	




