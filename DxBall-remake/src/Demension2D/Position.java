package Demension2D;

public class Position {
	public int x,y;
	public int dirX = 0;
	public int dirY = 0;
	public Position(){
		this.x = 0;
		this.y = 0;
	}
	public Position(int x,int y){
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDirX() {
		return dirX;
	}
	public void setDirX(int dirX) {
		this.dirX = dirX;
	}
	public int getDirY() {
		return dirY;
	}
	public void setDirY(int dirY) {
		this.dirY = dirY;
	}
	
}
