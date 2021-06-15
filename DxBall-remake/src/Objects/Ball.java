package Objects;

import Demension2D.Position;

public class Ball extends Objects{
	private int r;
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
		// TODO Auto-generated method stub
		
	}
	public void setDirection() {
		Diretion dir =Diretion.left;
	
	}
	














}


	




