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
	
	/*д��map.java��
	 * public void isGameOver() {
		//TODO �������±߽���Ϸ����
		if(this.getPosition().getX() == map.bottom) {
			gameOver = true;
		}
	}*/
	
	public int getR() {
		// TODO Auto-generated method stub
		return this.r;
	}














}


	




