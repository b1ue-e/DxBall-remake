package Objects;

import Demension2D.Position;


public abstract class Objects {
	/*生成Ball、Block、Board基本属性*/
	int width;
	int length;
	int speed;
	Position p = new Position();
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public Position getP() {
		return p;
	}
	public void setP(Position p) {
		this.p = p;
	}
	public abstract void runRt();
	
}
